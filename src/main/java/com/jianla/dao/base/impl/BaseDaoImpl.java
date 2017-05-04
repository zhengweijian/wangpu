package com.jianla.dao.base.impl;

import com.jianla.dao.base.BaseDaoI;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

@Repository("baseDao")
public class BaseDaoImpl<T> implements BaseDaoI<T> {

    private SessionFactory sessionFactory;

    @Override
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    public Serializable save(T o) {
        return this.getCurrentSession().save(o);
    }

    public void delete(T o) {
        this.getCurrentSession().delete(o);
    }

    public void update(T o) {
        this.getCurrentSession().update(o);
    }

    public void saveOrUpdate(T o) {
        this.getCurrentSession().saveOrUpdate(o);
    }

    public List<T> find(String hql) {
        return this.getCurrentSession().createQuery(hql).list();
    }

    public List<T> find(String hql, Object[] param) {
        Query q = this.getCurrentSession().createQuery(hql);
        if (param != null && param.length > 0) {
            for (int i = 0; i < param.length; i++) {
                q.setParameter(i, param[i]);
            }
        }
        return q.list();
    }

    public List<T> find(String hql, List<Object> param) {
        return find(hql, param.toArray());
    }

    public List<T> find(String hql, Object[] param, Integer page, Integer rows) {
        if (page == null || page < 1) {
            page = 1;
        }
        if (rows == null || rows < 1) {
            rows = 10;
        }
        Query q = this.getCurrentSession().createQuery(hql);
        if (param != null && param.length > 0) {
            for (int i = 0; i < param.length; i++) {
                q.setParameter(i, param[i]);

            }
        }
        return q.setFirstResult((page - 1) * rows).setMaxResults(rows).list();
    }

    public List<T> find(String hql, List<Object> param, Integer page,
                        Integer rows) {
        return find(hql, param.toArray(), page, rows);
    }

    /**
     * @param hql
     * @param param
     * @return
     * @author chengzg（来源于windflower）
     * @since 2014-07-11
     */
    public int countHqlResult(final String hql, final List<Object> param) {
        int count = 0;
        String fromHql = hql;
        // select子句与order by子句会影响count查询,进行简单的排除.
        fromHql = "from " + StringUtils.substringAfter(fromHql, "from");
        fromHql = StringUtils.substringBefore(fromHql, "order by");
        String countHql = "select count(*) " + fromHql;
        try {
            count = ((Long) createQuery(countHql, param).uniqueResult())
                    .intValue();
        } catch (Exception e) {
            throw new RuntimeException("hql can't be auto count, hql is:"
                    + countHql, e);
        }
        return count;
    }

    /**
     * @param queryString
     * @param param
     * @return
     * @author chengzg（来源于windflower）
     * @since 2014-07-11
     */
    protected Query createQuery(final String queryString,
                                final List<Object> param) {
        Assert.hasText(queryString, "queryString不能为空");
        Query query = getCurrentSession().createQuery(queryString);
        if (param != null && param.size() > 0) {
            for (int i = 0; i < param.size(); i++) {
                query.setParameter(i, param.get(i));
            }
        }
        return query;
    }

    public T get(Class<T> c, Serializable id) {
        return (T) this.getCurrentSession().get(c, id);
    }

    public T get(String hql, Object[] param) {
        List<T> l = this.find(hql, param);
        if (l != null && l.size() > 0) {
            return l.get(0);
        } else {
            return null;
        }
    }

    public T get(String hql, List<Object> param) {
        List<T> l = this.find(hql, param);
        if (l != null && l.size() > 0) {
            return l.get(0);
        } else {
            return null;
        }
    }

    public Long count(String hql) {
        return (Long) this.getCurrentSession().createQuery(hql).uniqueResult();
    }

    public Long count(String hql, Object[] param) {
        Query q = this.getCurrentSession().createQuery(hql);
        if (param != null && param.length > 0) {
            for (int i = 0; i < param.length; i++) {
                q.setParameter(i, param[i]);
            }
        }
        return (Long) q.uniqueResult();
    }

    public Long count(String hql, List<Object> param) {
        return count(hql, param.toArray());
    }

    @Override
    public BigDecimal sum(String hql, Object[] param) {
        Query q = this.getCurrentSession().createQuery(hql);
        if (param != null && param.length > 0) {
            for (int i = 0; i < param.length; i++) {
                q.setParameter(i, param[i]);
            }
        }
        Number result = (Number) q.uniqueResult();
        return result == null ? new BigDecimal(0) : new BigDecimal(result.doubleValue());
    }

    public Integer executeHql(String hql) {
        return this.getCurrentSession().createQuery(hql).executeUpdate();
    }

    public Integer executeHql(String hql, Object[] param) {
        Query q = this.getCurrentSession().createQuery(hql);
        if (param != null && param.length > 0) {
            for (int i = 0; i < param.length; i++) {
                q.setParameter(i, param[i]);
            }
        }
        return q.executeUpdate();
    }

    public Integer executeHql(String hql, List<Object> param) {
        Query q = this.getCurrentSession().createQuery(hql);
        if (param != null && param.size() > 0) {
            for (int i = 0; i < param.size(); i++) {
                q.setParameter(i, param.get(i));
            }
        }
        return q.executeUpdate();
    }

    public List findBySql(String sql) {
        SQLQuery q = this.getCurrentSession().createSQLQuery(sql);
        return q.list();
    }

    // pojoClass must have mapping
    @Override
    public List findBySql(String sql, List<Object> param) {
        SQLQuery q = this.getCurrentSession().createSQLQuery(sql);

        if (param != null && param.size() > 0) {
            for (int i = 0; i < param.size(); i++) {
                q.setParameter(i, param.get(i));
            }
        }

        return q.list();
    }

    // pojoClass must have mapping
    @Override
    public List findBySql(String sql, Object[] param) {
        SQLQuery q = this.getCurrentSession().createSQLQuery(sql);

        if (param != null && param.length > 0) {
            for (int i = 0; i < param.length; i++) {
                q.setParameter(i, param[i]);
            }
        }

        return q.list();
    }

    @Override
    public Long countBySql(String sql, Object[] param) {
        SQLQuery q = this.getCurrentSession().createSQLQuery(sql);
        if (param != null && param.length > 0) {
            for (int i = 0; i < param.length; i++) {
                q.setParameter(i, param[i]);
            }
        }
        BigInteger t = (BigInteger) q.uniqueResult();
        return t.longValue();
    }

    @Override
    public Long countBySql(String sql) {
        SQLQuery q = this.getCurrentSession().createSQLQuery(sql);
        BigInteger t = (BigInteger) q.uniqueResult();
        return t.longValue();
    }

    @Override
    public Double sumBySql(String sql) {
        SQLQuery q = this.getCurrentSession().createSQLQuery(sql);
        BigDecimal t = (BigDecimal) q.uniqueResult();
        if (t == null)
            return 0.0;
        return t.doubleValue();
    }
}
