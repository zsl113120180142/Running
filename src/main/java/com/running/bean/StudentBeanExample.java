package com.running.bean;

import java.util.ArrayList;
import java.util.List;

public class StudentBeanExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StudentBeanExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andSidIsNull() {
            addCriterion("sid is null");
            return (Criteria) this;
        }

        public Criteria andSidIsNotNull() {
            addCriterion("sid is not null");
            return (Criteria) this;
        }

        public Criteria andSidEqualTo(Integer value) {
            addCriterion("sid =", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidNotEqualTo(Integer value) {
            addCriterion("sid <>", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidGreaterThan(Integer value) {
            addCriterion("sid >", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidGreaterThanOrEqualTo(Integer value) {
            addCriterion("sid >=", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidLessThan(Integer value) {
            addCriterion("sid <", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidLessThanOrEqualTo(Integer value) {
            addCriterion("sid <=", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidIn(List<Integer> values) {
            addCriterion("sid in", values, "sid");
            return (Criteria) this;
        }

        public Criteria andSidNotIn(List<Integer> values) {
            addCriterion("sid not in", values, "sid");
            return (Criteria) this;
        }

        public Criteria andSidBetween(Integer value1, Integer value2) {
            addCriterion("sid between", value1, value2, "sid");
            return (Criteria) this;
        }

        public Criteria andSidNotBetween(Integer value1, Integer value2) {
            addCriterion("sid not between", value1, value2, "sid");
            return (Criteria) this;
        }

        public Criteria andSnameIsNull() {
            addCriterion("sname is null");
            return (Criteria) this;
        }

        public Criteria andSnameIsNotNull() {
            addCriterion("sname is not null");
            return (Criteria) this;
        }

        public Criteria andSnameEqualTo(String value) {
            addCriterion("sname =", value, "sname");
            return (Criteria) this;
        }

        public Criteria andSnameNotEqualTo(String value) {
            addCriterion("sname <>", value, "sname");
            return (Criteria) this;
        }

        public Criteria andSnameGreaterThan(String value) {
            addCriterion("sname >", value, "sname");
            return (Criteria) this;
        }

        public Criteria andSnameGreaterThanOrEqualTo(String value) {
            addCriterion("sname >=", value, "sname");
            return (Criteria) this;
        }

        public Criteria andSnameLessThan(String value) {
            addCriterion("sname <", value, "sname");
            return (Criteria) this;
        }

        public Criteria andSnameLessThanOrEqualTo(String value) {
            addCriterion("sname <=", value, "sname");
            return (Criteria) this;
        }

        public Criteria andSnameLike(String value) {
            addCriterion("sname like", value, "sname");
            return (Criteria) this;
        }

        public Criteria andSnameNotLike(String value) {
            addCriterion("sname not like", value, "sname");
            return (Criteria) this;
        }

        public Criteria andSnameIn(List<String> values) {
            addCriterion("sname in", values, "sname");
            return (Criteria) this;
        }

        public Criteria andSnameNotIn(List<String> values) {
            addCriterion("sname not in", values, "sname");
            return (Criteria) this;
        }

        public Criteria andSnameBetween(String value1, String value2) {
            addCriterion("sname between", value1, value2, "sname");
            return (Criteria) this;
        }

        public Criteria andSnameNotBetween(String value1, String value2) {
            addCriterion("sname not between", value1, value2, "sname");
            return (Criteria) this;
        }

        public Criteria andClidIsNull() {
            addCriterion("clid is null");
            return (Criteria) this;
        }

        public Criteria andClidIsNotNull() {
            addCriterion("clid is not null");
            return (Criteria) this;
        }

        public Criteria andClidEqualTo(Integer value) {
            addCriterion("clid =", value, "clid");
            return (Criteria) this;
        }

        public Criteria andClidNotEqualTo(Integer value) {
            addCriterion("clid <>", value, "clid");
            return (Criteria) this;
        }

        public Criteria andClidGreaterThan(Integer value) {
            addCriterion("clid >", value, "clid");
            return (Criteria) this;
        }

        public Criteria andClidGreaterThanOrEqualTo(Integer value) {
            addCriterion("clid >=", value, "clid");
            return (Criteria) this;
        }

        public Criteria andClidLessThan(Integer value) {
            addCriterion("clid <", value, "clid");
            return (Criteria) this;
        }

        public Criteria andClidLessThanOrEqualTo(Integer value) {
            addCriterion("clid <=", value, "clid");
            return (Criteria) this;
        }

        public Criteria andClidIn(List<Integer> values) {
            addCriterion("clid in", values, "clid");
            return (Criteria) this;
        }

        public Criteria andClidNotIn(List<Integer> values) {
            addCriterion("clid not in", values, "clid");
            return (Criteria) this;
        }

        public Criteria andClidBetween(Integer value1, Integer value2) {
            addCriterion("clid between", value1, value2, "clid");
            return (Criteria) this;
        }

        public Criteria andClidNotBetween(Integer value1, Integer value2) {
            addCriterion("clid not between", value1, value2, "clid");
            return (Criteria) this;
        }

        public Criteria andSexIsNull() {
            addCriterion("sex is null");
            return (Criteria) this;
        }

        public Criteria andSexIsNotNull() {
            addCriterion("sex is not null");
            return (Criteria) this;
        }

        public Criteria andSexEqualTo(String value) {
            addCriterion("sex =", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotEqualTo(String value) {
            addCriterion("sex <>", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThan(String value) {
            addCriterion("sex >", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThanOrEqualTo(String value) {
            addCriterion("sex >=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThan(String value) {
            addCriterion("sex <", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThanOrEqualTo(String value) {
            addCriterion("sex <=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLike(String value) {
            addCriterion("sex like", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotLike(String value) {
            addCriterion("sex not like", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexIn(List<String> values) {
            addCriterion("sex in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotIn(List<String> values) {
            addCriterion("sex not in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexBetween(String value1, String value2) {
            addCriterion("sex between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotBetween(String value1, String value2) {
            addCriterion("sex not between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andSnumIsNull() {
            addCriterion("snum is null");
            return (Criteria) this;
        }

        public Criteria andSnumIsNotNull() {
            addCriterion("snum is not null");
            return (Criteria) this;
        }

        public Criteria andSnumEqualTo(String value) {
            addCriterion("snum =", value, "snum");
            return (Criteria) this;
        }

        public Criteria andSnumNotEqualTo(String value) {
            addCriterion("snum <>", value, "snum");
            return (Criteria) this;
        }

        public Criteria andSnumGreaterThan(String value) {
            addCriterion("snum >", value, "snum");
            return (Criteria) this;
        }

        public Criteria andSnumGreaterThanOrEqualTo(String value) {
            addCriterion("snum >=", value, "snum");
            return (Criteria) this;
        }

        public Criteria andSnumLessThan(String value) {
            addCriterion("snum <", value, "snum");
            return (Criteria) this;
        }

        public Criteria andSnumLessThanOrEqualTo(String value) {
            addCriterion("snum <=", value, "snum");
            return (Criteria) this;
        }

        public Criteria andSnumLike(String value) {
            addCriterion("snum like", value, "snum");
            return (Criteria) this;
        }

        public Criteria andSnumNotLike(String value) {
            addCriterion("snum not like", value, "snum");
            return (Criteria) this;
        }

        public Criteria andSnumIn(List<String> values) {
            addCriterion("snum in", values, "snum");
            return (Criteria) this;
        }

        public Criteria andSnumNotIn(List<String> values) {
            addCriterion("snum not in", values, "snum");
            return (Criteria) this;
        }

        public Criteria andSnumBetween(String value1, String value2) {
            addCriterion("snum between", value1, value2, "snum");
            return (Criteria) this;
        }

        public Criteria andSnumNotBetween(String value1, String value2) {
            addCriterion("snum not between", value1, value2, "snum");
            return (Criteria) this;
        }

        public Criteria andInclassIsNull() {
            addCriterion("inclass is null");
            return (Criteria) this;
        }

        public Criteria andInclassIsNotNull() {
            addCriterion("inclass is not null");
            return (Criteria) this;
        }

        public Criteria andInclassEqualTo(Integer value) {
            addCriterion("inclass =", value, "inclass");
            return (Criteria) this;
        }

        public Criteria andInclassNotEqualTo(Integer value) {
            addCriterion("inclass <>", value, "inclass");
            return (Criteria) this;
        }

        public Criteria andInclassGreaterThan(Integer value) {
            addCriterion("inclass >", value, "inclass");
            return (Criteria) this;
        }

        public Criteria andInclassGreaterThanOrEqualTo(Integer value) {
            addCriterion("inclass >=", value, "inclass");
            return (Criteria) this;
        }

        public Criteria andInclassLessThan(Integer value) {
            addCriterion("inclass <", value, "inclass");
            return (Criteria) this;
        }

        public Criteria andInclassLessThanOrEqualTo(Integer value) {
            addCriterion("inclass <=", value, "inclass");
            return (Criteria) this;
        }

        public Criteria andInclassIn(List<Integer> values) {
            addCriterion("inclass in", values, "inclass");
            return (Criteria) this;
        }

        public Criteria andInclassNotIn(List<Integer> values) {
            addCriterion("inclass not in", values, "inclass");
            return (Criteria) this;
        }

        public Criteria andInclassBetween(Integer value1, Integer value2) {
            addCriterion("inclass between", value1, value2, "inclass");
            return (Criteria) this;
        }

        public Criteria andInclassNotBetween(Integer value1, Integer value2) {
            addCriterion("inclass not between", value1, value2, "inclass");
            return (Criteria) this;
        }

        public Criteria andSpeIsNull() {
            addCriterion("spe is null");
            return (Criteria) this;
        }

        public Criteria andSpeIsNotNull() {
            addCriterion("spe is not null");
            return (Criteria) this;
        }

        public Criteria andSpeEqualTo(Integer value) {
            addCriterion("spe =", value, "spe");
            return (Criteria) this;
        }

        public Criteria andSpeNotEqualTo(Integer value) {
            addCriterion("spe <>", value, "spe");
            return (Criteria) this;
        }

        public Criteria andSpeGreaterThan(Integer value) {
            addCriterion("spe >", value, "spe");
            return (Criteria) this;
        }

        public Criteria andSpeGreaterThanOrEqualTo(Integer value) {
            addCriterion("spe >=", value, "spe");
            return (Criteria) this;
        }

        public Criteria andSpeLessThan(Integer value) {
            addCriterion("spe <", value, "spe");
            return (Criteria) this;
        }

        public Criteria andSpeLessThanOrEqualTo(Integer value) {
            addCriterion("spe <=", value, "spe");
            return (Criteria) this;
        }

        public Criteria andSpeIn(List<Integer> values) {
            addCriterion("spe in", values, "spe");
            return (Criteria) this;
        }

        public Criteria andSpeNotIn(List<Integer> values) {
            addCriterion("spe not in", values, "spe");
            return (Criteria) this;
        }

        public Criteria andSpeBetween(Integer value1, Integer value2) {
            addCriterion("spe between", value1, value2, "spe");
            return (Criteria) this;
        }

        public Criteria andSpeNotBetween(Integer value1, Integer value2) {
            addCriterion("spe not between", value1, value2, "spe");
            return (Criteria) this;
        }

        public Criteria andSrunIsNull() {
            addCriterion("srun is null");
            return (Criteria) this;
        }

        public Criteria andSrunIsNotNull() {
            addCriterion("srun is not null");
            return (Criteria) this;
        }

        public Criteria andSrunEqualTo(Integer value) {
            addCriterion("srun =", value, "srun");
            return (Criteria) this;
        }

        public Criteria andSrunNotEqualTo(Integer value) {
            addCriterion("srun <>", value, "srun");
            return (Criteria) this;
        }

        public Criteria andSrunGreaterThan(Integer value) {
            addCriterion("srun >", value, "srun");
            return (Criteria) this;
        }

        public Criteria andSrunGreaterThanOrEqualTo(Integer value) {
            addCriterion("srun >=", value, "srun");
            return (Criteria) this;
        }

        public Criteria andSrunLessThan(Integer value) {
            addCriterion("srun <", value, "srun");
            return (Criteria) this;
        }

        public Criteria andSrunLessThanOrEqualTo(Integer value) {
            addCriterion("srun <=", value, "srun");
            return (Criteria) this;
        }

        public Criteria andSrunIn(List<Integer> values) {
            addCriterion("srun in", values, "srun");
            return (Criteria) this;
        }

        public Criteria andSrunNotIn(List<Integer> values) {
            addCriterion("srun not in", values, "srun");
            return (Criteria) this;
        }

        public Criteria andSrunBetween(Integer value1, Integer value2) {
            addCriterion("srun between", value1, value2, "srun");
            return (Criteria) this;
        }

        public Criteria andSrunNotBetween(Integer value1, Integer value2) {
            addCriterion("srun not between", value1, value2, "srun");
            return (Criteria) this;
        }

        public Criteria andSresultIsNull() {
            addCriterion("sresult is null");
            return (Criteria) this;
        }

        public Criteria andSresultIsNotNull() {
            addCriterion("sresult is not null");
            return (Criteria) this;
        }

        public Criteria andSresultEqualTo(Integer value) {
            addCriterion("sresult =", value, "sresult");
            return (Criteria) this;
        }

        public Criteria andSresultNotEqualTo(Integer value) {
            addCriterion("sresult <>", value, "sresult");
            return (Criteria) this;
        }

        public Criteria andSresultGreaterThan(Integer value) {
            addCriterion("sresult >", value, "sresult");
            return (Criteria) this;
        }

        public Criteria andSresultGreaterThanOrEqualTo(Integer value) {
            addCriterion("sresult >=", value, "sresult");
            return (Criteria) this;
        }

        public Criteria andSresultLessThan(Integer value) {
            addCriterion("sresult <", value, "sresult");
            return (Criteria) this;
        }

        public Criteria andSresultLessThanOrEqualTo(Integer value) {
            addCriterion("sresult <=", value, "sresult");
            return (Criteria) this;
        }

        public Criteria andSresultIn(List<Integer> values) {
            addCriterion("sresult in", values, "sresult");
            return (Criteria) this;
        }

        public Criteria andSresultNotIn(List<Integer> values) {
            addCriterion("sresult not in", values, "sresult");
            return (Criteria) this;
        }

        public Criteria andSresultBetween(Integer value1, Integer value2) {
            addCriterion("sresult between", value1, value2, "sresult");
            return (Criteria) this;
        }

        public Criteria andSresultNotBetween(Integer value1, Integer value2) {
            addCriterion("sresult not between", value1, value2, "sresult");
            return (Criteria) this;
        }

        public Criteria andSpictureIsNull() {
            addCriterion("spicture is null");
            return (Criteria) this;
        }

        public Criteria andSpictureIsNotNull() {
            addCriterion("spicture is not null");
            return (Criteria) this;
        }

        public Criteria andSpictureEqualTo(String value) {
            addCriterion("spicture =", value, "spicture");
            return (Criteria) this;
        }

        public Criteria andSpictureNotEqualTo(String value) {
            addCriterion("spicture <>", value, "spicture");
            return (Criteria) this;
        }

        public Criteria andSpictureGreaterThan(String value) {
            addCriterion("spicture >", value, "spicture");
            return (Criteria) this;
        }

        public Criteria andSpictureGreaterThanOrEqualTo(String value) {
            addCriterion("spicture >=", value, "spicture");
            return (Criteria) this;
        }

        public Criteria andSpictureLessThan(String value) {
            addCriterion("spicture <", value, "spicture");
            return (Criteria) this;
        }

        public Criteria andSpictureLessThanOrEqualTo(String value) {
            addCriterion("spicture <=", value, "spicture");
            return (Criteria) this;
        }

        public Criteria andSpictureLike(String value) {
            addCriterion("spicture like", value, "spicture");
            return (Criteria) this;
        }

        public Criteria andSpictureNotLike(String value) {
            addCriterion("spicture not like", value, "spicture");
            return (Criteria) this;
        }

        public Criteria andSpictureIn(List<String> values) {
            addCriterion("spicture in", values, "spicture");
            return (Criteria) this;
        }

        public Criteria andSpictureNotIn(List<String> values) {
            addCriterion("spicture not in", values, "spicture");
            return (Criteria) this;
        }

        public Criteria andSpictureBetween(String value1, String value2) {
            addCriterion("spicture between", value1, value2, "spicture");
            return (Criteria) this;
        }

        public Criteria andSpictureNotBetween(String value1, String value2) {
            addCriterion("spicture not between", value1, value2, "spicture");
            return (Criteria) this;
        }

        public Criteria andSpasswordIsNull() {
            addCriterion("spassword is null");
            return (Criteria) this;
        }

        public Criteria andSpasswordIsNotNull() {
            addCriterion("spassword is not null");
            return (Criteria) this;
        }

        public Criteria andSpasswordEqualTo(String value) {
            addCriterion("spassword =", value, "spassword");
            return (Criteria) this;
        }

        public Criteria andSpasswordNotEqualTo(String value) {
            addCriterion("spassword <>", value, "spassword");
            return (Criteria) this;
        }

        public Criteria andSpasswordGreaterThan(String value) {
            addCriterion("spassword >", value, "spassword");
            return (Criteria) this;
        }

        public Criteria andSpasswordGreaterThanOrEqualTo(String value) {
            addCriterion("spassword >=", value, "spassword");
            return (Criteria) this;
        }

        public Criteria andSpasswordLessThan(String value) {
            addCriterion("spassword <", value, "spassword");
            return (Criteria) this;
        }

        public Criteria andSpasswordLessThanOrEqualTo(String value) {
            addCriterion("spassword <=", value, "spassword");
            return (Criteria) this;
        }

        public Criteria andSpasswordLike(String value) {
            addCriterion("spassword like", value, "spassword");
            return (Criteria) this;
        }

        public Criteria andSpasswordNotLike(String value) {
            addCriterion("spassword not like", value, "spassword");
            return (Criteria) this;
        }

        public Criteria andSpasswordIn(List<String> values) {
            addCriterion("spassword in", values, "spassword");
            return (Criteria) this;
        }

        public Criteria andSpasswordNotIn(List<String> values) {
            addCriterion("spassword not in", values, "spassword");
            return (Criteria) this;
        }

        public Criteria andSpasswordBetween(String value1, String value2) {
            addCriterion("spassword between", value1, value2, "spassword");
            return (Criteria) this;
        }

        public Criteria andSpasswordNotBetween(String value1, String value2) {
            addCriterion("spassword not between", value1, value2, "spassword");
            return (Criteria) this;
        }

        public Criteria andSntIsNull() {
            addCriterion("snt is null");
            return (Criteria) this;
        }

        public Criteria andSntIsNotNull() {
            addCriterion("snt is not null");
            return (Criteria) this;
        }

        public Criteria andSntEqualTo(Integer value) {
            addCriterion("snt =", value, "snt");
            return (Criteria) this;
        }

        public Criteria andSntNotEqualTo(Integer value) {
            addCriterion("snt <>", value, "snt");
            return (Criteria) this;
        }

        public Criteria andSntGreaterThan(Integer value) {
            addCriterion("snt >", value, "snt");
            return (Criteria) this;
        }

        public Criteria andSntGreaterThanOrEqualTo(Integer value) {
            addCriterion("snt >=", value, "snt");
            return (Criteria) this;
        }

        public Criteria andSntLessThan(Integer value) {
            addCriterion("snt <", value, "snt");
            return (Criteria) this;
        }

        public Criteria andSntLessThanOrEqualTo(Integer value) {
            addCriterion("snt <=", value, "snt");
            return (Criteria) this;
        }

        public Criteria andSntIn(List<Integer> values) {
            addCriterion("snt in", values, "snt");
            return (Criteria) this;
        }

        public Criteria andSntNotIn(List<Integer> values) {
            addCriterion("snt not in", values, "snt");
            return (Criteria) this;
        }

        public Criteria andSntBetween(Integer value1, Integer value2) {
            addCriterion("snt between", value1, value2, "snt");
            return (Criteria) this;
        }

        public Criteria andSntNotBetween(Integer value1, Integer value2) {
            addCriterion("snt not between", value1, value2, "snt");
            return (Criteria) this;
        }

        public Criteria andSdeleteIsNull() {
            addCriterion("sdelete is null");
            return (Criteria) this;
        }

        public Criteria andSdeleteIsNotNull() {
            addCriterion("sdelete is not null");
            return (Criteria) this;
        }

        public Criteria andSdeleteEqualTo(Integer value) {
            addCriterion("sdelete =", value, "sdelete");
            return (Criteria) this;
        }

        public Criteria andSdeleteNotEqualTo(Integer value) {
            addCriterion("sdelete <>", value, "sdelete");
            return (Criteria) this;
        }

        public Criteria andSdeleteGreaterThan(Integer value) {
            addCriterion("sdelete >", value, "sdelete");
            return (Criteria) this;
        }

        public Criteria andSdeleteGreaterThanOrEqualTo(Integer value) {
            addCriterion("sdelete >=", value, "sdelete");
            return (Criteria) this;
        }

        public Criteria andSdeleteLessThan(Integer value) {
            addCriterion("sdelete <", value, "sdelete");
            return (Criteria) this;
        }

        public Criteria andSdeleteLessThanOrEqualTo(Integer value) {
            addCriterion("sdelete <=", value, "sdelete");
            return (Criteria) this;
        }

        public Criteria andSdeleteIn(List<Integer> values) {
            addCriterion("sdelete in", values, "sdelete");
            return (Criteria) this;
        }

        public Criteria andSdeleteNotIn(List<Integer> values) {
            addCriterion("sdelete not in", values, "sdelete");
            return (Criteria) this;
        }

        public Criteria andSdeleteBetween(Integer value1, Integer value2) {
            addCriterion("sdelete between", value1, value2, "sdelete");
            return (Criteria) this;
        }

        public Criteria andSdeleteNotBetween(Integer value1, Integer value2) {
            addCriterion("sdelete not between", value1, value2, "sdelete");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}