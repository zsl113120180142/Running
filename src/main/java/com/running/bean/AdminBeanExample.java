package com.running.bean;

import java.util.ArrayList;
import java.util.List;

public class AdminBeanExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AdminBeanExample() {
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

        public Criteria andAidIsNull() {
            addCriterion("aid is null");
            return (Criteria) this;
        }

        public Criteria andAidIsNotNull() {
            addCriterion("aid is not null");
            return (Criteria) this;
        }

        public Criteria andAidEqualTo(Integer value) {
            addCriterion("aid =", value, "aid");
            return (Criteria) this;
        }

        public Criteria andAidNotEqualTo(Integer value) {
            addCriterion("aid <>", value, "aid");
            return (Criteria) this;
        }

        public Criteria andAidGreaterThan(Integer value) {
            addCriterion("aid >", value, "aid");
            return (Criteria) this;
        }

        public Criteria andAidGreaterThanOrEqualTo(Integer value) {
            addCriterion("aid >=", value, "aid");
            return (Criteria) this;
        }

        public Criteria andAidLessThan(Integer value) {
            addCriterion("aid <", value, "aid");
            return (Criteria) this;
        }

        public Criteria andAidLessThanOrEqualTo(Integer value) {
            addCriterion("aid <=", value, "aid");
            return (Criteria) this;
        }

        public Criteria andAidIn(List<Integer> values) {
            addCriterion("aid in", values, "aid");
            return (Criteria) this;
        }

        public Criteria andAidNotIn(List<Integer> values) {
            addCriterion("aid not in", values, "aid");
            return (Criteria) this;
        }

        public Criteria andAidBetween(Integer value1, Integer value2) {
            addCriterion("aid between", value1, value2, "aid");
            return (Criteria) this;
        }

        public Criteria andAidNotBetween(Integer value1, Integer value2) {
            addCriterion("aid not between", value1, value2, "aid");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNull() {
            addCriterion("username is null");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNotNull() {
            addCriterion("username is not null");
            return (Criteria) this;
        }

        public Criteria andUsernameEqualTo(String value) {
            addCriterion("username =", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotEqualTo(String value) {
            addCriterion("username <>", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThan(String value) {
            addCriterion("username >", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("username >=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThan(String value) {
            addCriterion("username <", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThanOrEqualTo(String value) {
            addCriterion("username <=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLike(String value) {
            addCriterion("username like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotLike(String value) {
            addCriterion("username not like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameIn(List<String> values) {
            addCriterion("username in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotIn(List<String> values) {
            addCriterion("username not in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameBetween(String value1, String value2) {
            addCriterion("username between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotBetween(String value1, String value2) {
            addCriterion("username not between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNull() {
            addCriterion("password is null");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNotNull() {
            addCriterion("password is not null");
            return (Criteria) this;
        }

        public Criteria andPasswordEqualTo(String value) {
            addCriterion("password =", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotEqualTo(String value) {
            addCriterion("password <>", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThan(String value) {
            addCriterion("password >", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("password >=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThan(String value) {
            addCriterion("password <", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThanOrEqualTo(String value) {
            addCriterion("password <=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLike(String value) {
            addCriterion("password like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotLike(String value) {
            addCriterion("password not like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordIn(List<String> values) {
            addCriterion("password in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotIn(List<String> values) {
            addCriterion("password not in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordBetween(String value1, String value2) {
            addCriterion("password between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotBetween(String value1, String value2) {
            addCriterion("password not between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNull() {
            addCriterion("phone is null");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNotNull() {
            addCriterion("phone is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneEqualTo(String value) {
            addCriterion("phone =", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotEqualTo(String value) {
            addCriterion("phone <>", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThan(String value) {
            addCriterion("phone >", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("phone >=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThan(String value) {
            addCriterion("phone <", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThanOrEqualTo(String value) {
            addCriterion("phone <=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLike(String value) {
            addCriterion("phone like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotLike(String value) {
            addCriterion("phone not like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneIn(List<String> values) {
            addCriterion("phone in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotIn(List<String> values) {
            addCriterion("phone not in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneBetween(String value1, String value2) {
            addCriterion("phone between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotBetween(String value1, String value2) {
            addCriterion("phone not between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andApictureIsNull() {
            addCriterion("apicture is null");
            return (Criteria) this;
        }

        public Criteria andApictureIsNotNull() {
            addCriterion("apicture is not null");
            return (Criteria) this;
        }

        public Criteria andApictureEqualTo(String value) {
            addCriterion("apicture =", value, "apicture");
            return (Criteria) this;
        }

        public Criteria andApictureNotEqualTo(String value) {
            addCriterion("apicture <>", value, "apicture");
            return (Criteria) this;
        }

        public Criteria andApictureGreaterThan(String value) {
            addCriterion("apicture >", value, "apicture");
            return (Criteria) this;
        }

        public Criteria andApictureGreaterThanOrEqualTo(String value) {
            addCriterion("apicture >=", value, "apicture");
            return (Criteria) this;
        }

        public Criteria andApictureLessThan(String value) {
            addCriterion("apicture <", value, "apicture");
            return (Criteria) this;
        }

        public Criteria andApictureLessThanOrEqualTo(String value) {
            addCriterion("apicture <=", value, "apicture");
            return (Criteria) this;
        }

        public Criteria andApictureLike(String value) {
            addCriterion("apicture like", value, "apicture");
            return (Criteria) this;
        }

        public Criteria andApictureNotLike(String value) {
            addCriterion("apicture not like", value, "apicture");
            return (Criteria) this;
        }

        public Criteria andApictureIn(List<String> values) {
            addCriterion("apicture in", values, "apicture");
            return (Criteria) this;
        }

        public Criteria andApictureNotIn(List<String> values) {
            addCriterion("apicture not in", values, "apicture");
            return (Criteria) this;
        }

        public Criteria andApictureBetween(String value1, String value2) {
            addCriterion("apicture between", value1, value2, "apicture");
            return (Criteria) this;
        }

        public Criteria andApictureNotBetween(String value1, String value2) {
            addCriterion("apicture not between", value1, value2, "apicture");
            return (Criteria) this;
        }

        public Criteria andAnameIsNull() {
            addCriterion("aname is null");
            return (Criteria) this;
        }

        public Criteria andAnameIsNotNull() {
            addCriterion("aname is not null");
            return (Criteria) this;
        }

        public Criteria andAnameEqualTo(String value) {
            addCriterion("aname =", value, "aname");
            return (Criteria) this;
        }

        public Criteria andAnameNotEqualTo(String value) {
            addCriterion("aname <>", value, "aname");
            return (Criteria) this;
        }

        public Criteria andAnameGreaterThan(String value) {
            addCriterion("aname >", value, "aname");
            return (Criteria) this;
        }

        public Criteria andAnameGreaterThanOrEqualTo(String value) {
            addCriterion("aname >=", value, "aname");
            return (Criteria) this;
        }

        public Criteria andAnameLessThan(String value) {
            addCriterion("aname <", value, "aname");
            return (Criteria) this;
        }

        public Criteria andAnameLessThanOrEqualTo(String value) {
            addCriterion("aname <=", value, "aname");
            return (Criteria) this;
        }

        public Criteria andAnameLike(String value) {
            addCriterion("aname like", value, "aname");
            return (Criteria) this;
        }

        public Criteria andAnameNotLike(String value) {
            addCriterion("aname not like", value, "aname");
            return (Criteria) this;
        }

        public Criteria andAnameIn(List<String> values) {
            addCriterion("aname in", values, "aname");
            return (Criteria) this;
        }

        public Criteria andAnameNotIn(List<String> values) {
            addCriterion("aname not in", values, "aname");
            return (Criteria) this;
        }

        public Criteria andAnameBetween(String value1, String value2) {
            addCriterion("aname between", value1, value2, "aname");
            return (Criteria) this;
        }

        public Criteria andAnameNotBetween(String value1, String value2) {
            addCriterion("aname not between", value1, value2, "aname");
            return (Criteria) this;
        }

        public Criteria andIdenIsNull() {
            addCriterion("iden is null");
            return (Criteria) this;
        }

        public Criteria andIdenIsNotNull() {
            addCriterion("iden is not null");
            return (Criteria) this;
        }

        public Criteria andIdenEqualTo(String value) {
            addCriterion("iden =", value, "iden");
            return (Criteria) this;
        }

        public Criteria andIdenNotEqualTo(String value) {
            addCriterion("iden <>", value, "iden");
            return (Criteria) this;
        }

        public Criteria andIdenGreaterThan(String value) {
            addCriterion("iden >", value, "iden");
            return (Criteria) this;
        }

        public Criteria andIdenGreaterThanOrEqualTo(String value) {
            addCriterion("iden >=", value, "iden");
            return (Criteria) this;
        }

        public Criteria andIdenLessThan(String value) {
            addCriterion("iden <", value, "iden");
            return (Criteria) this;
        }

        public Criteria andIdenLessThanOrEqualTo(String value) {
            addCriterion("iden <=", value, "iden");
            return (Criteria) this;
        }

        public Criteria andIdenLike(String value) {
            addCriterion("iden like", value, "iden");
            return (Criteria) this;
        }

        public Criteria andIdenNotLike(String value) {
            addCriterion("iden not like", value, "iden");
            return (Criteria) this;
        }

        public Criteria andIdenIn(List<String> values) {
            addCriterion("iden in", values, "iden");
            return (Criteria) this;
        }

        public Criteria andIdenNotIn(List<String> values) {
            addCriterion("iden not in", values, "iden");
            return (Criteria) this;
        }

        public Criteria andIdenBetween(String value1, String value2) {
            addCriterion("iden between", value1, value2, "iden");
            return (Criteria) this;
        }

        public Criteria andIdenNotBetween(String value1, String value2) {
            addCriterion("iden not between", value1, value2, "iden");
            return (Criteria) this;
        }

        public Criteria andWorksIsNull() {
            addCriterion("works is null");
            return (Criteria) this;
        }

        public Criteria andWorksIsNotNull() {
            addCriterion("works is not null");
            return (Criteria) this;
        }

        public Criteria andWorksEqualTo(Integer value) {
            addCriterion("works =", value, "works");
            return (Criteria) this;
        }

        public Criteria andWorksNotEqualTo(Integer value) {
            addCriterion("works <>", value, "works");
            return (Criteria) this;
        }

        public Criteria andWorksGreaterThan(Integer value) {
            addCriterion("works >", value, "works");
            return (Criteria) this;
        }

        public Criteria andWorksGreaterThanOrEqualTo(Integer value) {
            addCriterion("works >=", value, "works");
            return (Criteria) this;
        }

        public Criteria andWorksLessThan(Integer value) {
            addCriterion("works <", value, "works");
            return (Criteria) this;
        }

        public Criteria andWorksLessThanOrEqualTo(Integer value) {
            addCriterion("works <=", value, "works");
            return (Criteria) this;
        }

        public Criteria andWorksIn(List<Integer> values) {
            addCriterion("works in", values, "works");
            return (Criteria) this;
        }

        public Criteria andWorksNotIn(List<Integer> values) {
            addCriterion("works not in", values, "works");
            return (Criteria) this;
        }

        public Criteria andWorksBetween(Integer value1, Integer value2) {
            addCriterion("works between", value1, value2, "works");
            return (Criteria) this;
        }

        public Criteria andWorksNotBetween(Integer value1, Integer value2) {
            addCriterion("works not between", value1, value2, "works");
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