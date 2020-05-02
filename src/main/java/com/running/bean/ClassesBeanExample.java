package com.running.bean;

import java.util.ArrayList;
import java.util.List;

public class ClassesBeanExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ClassesBeanExample() {
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

        public Criteria andClnameIsNull() {
            addCriterion("clname is null");
            return (Criteria) this;
        }

        public Criteria andClnameIsNotNull() {
            addCriterion("clname is not null");
            return (Criteria) this;
        }

        public Criteria andClnameEqualTo(String value) {
            addCriterion("clname =", value, "clname");
            return (Criteria) this;
        }

        public Criteria andClnameNotEqualTo(String value) {
            addCriterion("clname <>", value, "clname");
            return (Criteria) this;
        }

        public Criteria andClnameGreaterThan(String value) {
            addCriterion("clname >", value, "clname");
            return (Criteria) this;
        }

        public Criteria andClnameGreaterThanOrEqualTo(String value) {
            addCriterion("clname >=", value, "clname");
            return (Criteria) this;
        }

        public Criteria andClnameLessThan(String value) {
            addCriterion("clname <", value, "clname");
            return (Criteria) this;
        }

        public Criteria andClnameLessThanOrEqualTo(String value) {
            addCriterion("clname <=", value, "clname");
            return (Criteria) this;
        }

        public Criteria andClnameLike(String value) {
            addCriterion("clname like", value, "clname");
            return (Criteria) this;
        }

        public Criteria andClnameNotLike(String value) {
            addCriterion("clname not like", value, "clname");
            return (Criteria) this;
        }

        public Criteria andClnameIn(List<String> values) {
            addCriterion("clname in", values, "clname");
            return (Criteria) this;
        }

        public Criteria andClnameNotIn(List<String> values) {
            addCriterion("clname not in", values, "clname");
            return (Criteria) this;
        }

        public Criteria andClnameBetween(String value1, String value2) {
            addCriterion("clname between", value1, value2, "clname");
            return (Criteria) this;
        }

        public Criteria andClnameNotBetween(String value1, String value2) {
            addCriterion("clname not between", value1, value2, "clname");
            return (Criteria) this;
        }

        public Criteria andGidIsNull() {
            addCriterion("gid is null");
            return (Criteria) this;
        }

        public Criteria andGidIsNotNull() {
            addCriterion("gid is not null");
            return (Criteria) this;
        }

        public Criteria andGidEqualTo(Integer value) {
            addCriterion("gid =", value, "gid");
            return (Criteria) this;
        }

        public Criteria andGidNotEqualTo(Integer value) {
            addCriterion("gid <>", value, "gid");
            return (Criteria) this;
        }

        public Criteria andGidGreaterThan(Integer value) {
            addCriterion("gid >", value, "gid");
            return (Criteria) this;
        }

        public Criteria andGidGreaterThanOrEqualTo(Integer value) {
            addCriterion("gid >=", value, "gid");
            return (Criteria) this;
        }

        public Criteria andGidLessThan(Integer value) {
            addCriterion("gid <", value, "gid");
            return (Criteria) this;
        }

        public Criteria andGidLessThanOrEqualTo(Integer value) {
            addCriterion("gid <=", value, "gid");
            return (Criteria) this;
        }

        public Criteria andGidIn(List<Integer> values) {
            addCriterion("gid in", values, "gid");
            return (Criteria) this;
        }

        public Criteria andGidNotIn(List<Integer> values) {
            addCriterion("gid not in", values, "gid");
            return (Criteria) this;
        }

        public Criteria andGidBetween(Integer value1, Integer value2) {
            addCriterion("gid between", value1, value2, "gid");
            return (Criteria) this;
        }

        public Criteria andGidNotBetween(Integer value1, Integer value2) {
            addCriterion("gid not between", value1, value2, "gid");
            return (Criteria) this;
        }

        public Criteria andCldeleteIsNull() {
            addCriterion("cldelete is null");
            return (Criteria) this;
        }

        public Criteria andCldeleteIsNotNull() {
            addCriterion("cldelete is not null");
            return (Criteria) this;
        }

        public Criteria andCldeleteEqualTo(Integer value) {
            addCriterion("cldelete =", value, "cldelete");
            return (Criteria) this;
        }

        public Criteria andCldeleteNotEqualTo(Integer value) {
            addCriterion("cldelete <>", value, "cldelete");
            return (Criteria) this;
        }

        public Criteria andCldeleteGreaterThan(Integer value) {
            addCriterion("cldelete >", value, "cldelete");
            return (Criteria) this;
        }

        public Criteria andCldeleteGreaterThanOrEqualTo(Integer value) {
            addCriterion("cldelete >=", value, "cldelete");
            return (Criteria) this;
        }

        public Criteria andCldeleteLessThan(Integer value) {
            addCriterion("cldelete <", value, "cldelete");
            return (Criteria) this;
        }

        public Criteria andCldeleteLessThanOrEqualTo(Integer value) {
            addCriterion("cldelete <=", value, "cldelete");
            return (Criteria) this;
        }

        public Criteria andCldeleteIn(List<Integer> values) {
            addCriterion("cldelete in", values, "cldelete");
            return (Criteria) this;
        }

        public Criteria andCldeleteNotIn(List<Integer> values) {
            addCriterion("cldelete not in", values, "cldelete");
            return (Criteria) this;
        }

        public Criteria andCldeleteBetween(Integer value1, Integer value2) {
            addCriterion("cldelete between", value1, value2, "cldelete");
            return (Criteria) this;
        }

        public Criteria andCldeleteNotBetween(Integer value1, Integer value2) {
            addCriterion("cldelete not between", value1, value2, "cldelete");
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