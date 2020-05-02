package com.running.bean;

import java.util.ArrayList;
import java.util.List;

public class ResultBeanExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ResultBeanExample() {
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

        public Criteria andRidIsNull() {
            addCriterion("rid is null");
            return (Criteria) this;
        }

        public Criteria andRidIsNotNull() {
            addCriterion("rid is not null");
            return (Criteria) this;
        }

        public Criteria andRidEqualTo(Integer value) {
            addCriterion("rid =", value, "rid");
            return (Criteria) this;
        }

        public Criteria andRidNotEqualTo(Integer value) {
            addCriterion("rid <>", value, "rid");
            return (Criteria) this;
        }

        public Criteria andRidGreaterThan(Integer value) {
            addCriterion("rid >", value, "rid");
            return (Criteria) this;
        }

        public Criteria andRidGreaterThanOrEqualTo(Integer value) {
            addCriterion("rid >=", value, "rid");
            return (Criteria) this;
        }

        public Criteria andRidLessThan(Integer value) {
            addCriterion("rid <", value, "rid");
            return (Criteria) this;
        }

        public Criteria andRidLessThanOrEqualTo(Integer value) {
            addCriterion("rid <=", value, "rid");
            return (Criteria) this;
        }

        public Criteria andRidIn(List<Integer> values) {
            addCriterion("rid in", values, "rid");
            return (Criteria) this;
        }

        public Criteria andRidNotIn(List<Integer> values) {
            addCriterion("rid not in", values, "rid");
            return (Criteria) this;
        }

        public Criteria andRidBetween(Integer value1, Integer value2) {
            addCriterion("rid between", value1, value2, "rid");
            return (Criteria) this;
        }

        public Criteria andRidNotBetween(Integer value1, Integer value2) {
            addCriterion("rid not between", value1, value2, "rid");
            return (Criteria) this;
        }

        public Criteria andMinresultIsNull() {
            addCriterion("minresult is null");
            return (Criteria) this;
        }

        public Criteria andMinresultIsNotNull() {
            addCriterion("minresult is not null");
            return (Criteria) this;
        }

        public Criteria andMinresultEqualTo(Integer value) {
            addCriterion("minresult =", value, "minresult");
            return (Criteria) this;
        }

        public Criteria andMinresultNotEqualTo(Integer value) {
            addCriterion("minresult <>", value, "minresult");
            return (Criteria) this;
        }

        public Criteria andMinresultGreaterThan(Integer value) {
            addCriterion("minresult >", value, "minresult");
            return (Criteria) this;
        }

        public Criteria andMinresultGreaterThanOrEqualTo(Integer value) {
            addCriterion("minresult >=", value, "minresult");
            return (Criteria) this;
        }

        public Criteria andMinresultLessThan(Integer value) {
            addCriterion("minresult <", value, "minresult");
            return (Criteria) this;
        }

        public Criteria andMinresultLessThanOrEqualTo(Integer value) {
            addCriterion("minresult <=", value, "minresult");
            return (Criteria) this;
        }

        public Criteria andMinresultIn(List<Integer> values) {
            addCriterion("minresult in", values, "minresult");
            return (Criteria) this;
        }

        public Criteria andMinresultNotIn(List<Integer> values) {
            addCriterion("minresult not in", values, "minresult");
            return (Criteria) this;
        }

        public Criteria andMinresultBetween(Integer value1, Integer value2) {
            addCriterion("minresult between", value1, value2, "minresult");
            return (Criteria) this;
        }

        public Criteria andMinresultNotBetween(Integer value1, Integer value2) {
            addCriterion("minresult not between", value1, value2, "minresult");
            return (Criteria) this;
        }

        public Criteria andRresultIsNull() {
            addCriterion("rresult is null");
            return (Criteria) this;
        }

        public Criteria andRresultIsNotNull() {
            addCriterion("rresult is not null");
            return (Criteria) this;
        }

        public Criteria andRresultEqualTo(Integer value) {
            addCriterion("rresult =", value, "rresult");
            return (Criteria) this;
        }

        public Criteria andRresultNotEqualTo(Integer value) {
            addCriterion("rresult <>", value, "rresult");
            return (Criteria) this;
        }

        public Criteria andRresultGreaterThan(Integer value) {
            addCriterion("rresult >", value, "rresult");
            return (Criteria) this;
        }

        public Criteria andRresultGreaterThanOrEqualTo(Integer value) {
            addCriterion("rresult >=", value, "rresult");
            return (Criteria) this;
        }

        public Criteria andRresultLessThan(Integer value) {
            addCriterion("rresult <", value, "rresult");
            return (Criteria) this;
        }

        public Criteria andRresultLessThanOrEqualTo(Integer value) {
            addCriterion("rresult <=", value, "rresult");
            return (Criteria) this;
        }

        public Criteria andRresultIn(List<Integer> values) {
            addCriterion("rresult in", values, "rresult");
            return (Criteria) this;
        }

        public Criteria andRresultNotIn(List<Integer> values) {
            addCriterion("rresult not in", values, "rresult");
            return (Criteria) this;
        }

        public Criteria andRresultBetween(Integer value1, Integer value2) {
            addCriterion("rresult between", value1, value2, "rresult");
            return (Criteria) this;
        }

        public Criteria andRresultNotBetween(Integer value1, Integer value2) {
            addCriterion("rresult not between", value1, value2, "rresult");
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