package com.liu.managerial_system.domain;

import java.util.ArrayList;
import java.util.List;

public class AchievementExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AchievementExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andAchieveCatagoryIsNull() {
            addCriterion("achieve_catagory is null");
            return (Criteria) this;
        }

        public Criteria andAchieveCatagoryIsNotNull() {
            addCriterion("achieve_catagory is not null");
            return (Criteria) this;
        }

        public Criteria andAchieveCatagoryEqualTo(String value) {
            addCriterion("achieve_catagory =", value, "achieveCatagory");
            return (Criteria) this;
        }

        public Criteria andAchieveCatagoryNotEqualTo(String value) {
            addCriterion("achieve_catagory <>", value, "achieveCatagory");
            return (Criteria) this;
        }

        public Criteria andAchieveCatagoryGreaterThan(String value) {
            addCriterion("achieve_catagory >", value, "achieveCatagory");
            return (Criteria) this;
        }

        public Criteria andAchieveCatagoryGreaterThanOrEqualTo(String value) {
            addCriterion("achieve_catagory >=", value, "achieveCatagory");
            return (Criteria) this;
        }

        public Criteria andAchieveCatagoryLessThan(String value) {
            addCriterion("achieve_catagory <", value, "achieveCatagory");
            return (Criteria) this;
        }

        public Criteria andAchieveCatagoryLessThanOrEqualTo(String value) {
            addCriterion("achieve_catagory <=", value, "achieveCatagory");
            return (Criteria) this;
        }

        public Criteria andAchieveCatagoryLike(String value) {
            addCriterion("achieve_catagory like", value, "achieveCatagory");
            return (Criteria) this;
        }

        public Criteria andAchieveCatagoryNotLike(String value) {
            addCriterion("achieve_catagory not like", value, "achieveCatagory");
            return (Criteria) this;
        }

        public Criteria andAchieveCatagoryIn(List<String> values) {
            addCriterion("achieve_catagory in", values, "achieveCatagory");
            return (Criteria) this;
        }

        public Criteria andAchieveCatagoryNotIn(List<String> values) {
            addCriterion("achieve_catagory not in", values, "achieveCatagory");
            return (Criteria) this;
        }

        public Criteria andAchieveCatagoryBetween(String value1, String value2) {
            addCriterion("achieve_catagory between", value1, value2, "achieveCatagory");
            return (Criteria) this;
        }

        public Criteria andAchieveCatagoryNotBetween(String value1, String value2) {
            addCriterion("achieve_catagory not between", value1, value2, "achieveCatagory");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("`name` is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("`name` is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("`name` =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("`name` <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("`name` >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("`name` >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("`name` <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("`name` <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("`name` like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("`name` not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("`name` in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("`name` not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("`name` between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("`name` not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andFirstAuthorIsNull() {
            addCriterion("first_author is null");
            return (Criteria) this;
        }

        public Criteria andFirstAuthorIsNotNull() {
            addCriterion("first_author is not null");
            return (Criteria) this;
        }

        public Criteria andFirstAuthorEqualTo(String value) {
            addCriterion("first_author =", value, "firstAuthor");
            return (Criteria) this;
        }

        public Criteria andFirstAuthorNotEqualTo(String value) {
            addCriterion("first_author <>", value, "firstAuthor");
            return (Criteria) this;
        }

        public Criteria andFirstAuthorGreaterThan(String value) {
            addCriterion("first_author >", value, "firstAuthor");
            return (Criteria) this;
        }

        public Criteria andFirstAuthorGreaterThanOrEqualTo(String value) {
            addCriterion("first_author >=", value, "firstAuthor");
            return (Criteria) this;
        }

        public Criteria andFirstAuthorLessThan(String value) {
            addCriterion("first_author <", value, "firstAuthor");
            return (Criteria) this;
        }

        public Criteria andFirstAuthorLessThanOrEqualTo(String value) {
            addCriterion("first_author <=", value, "firstAuthor");
            return (Criteria) this;
        }

        public Criteria andFirstAuthorLike(String value) {
            addCriterion("first_author like", value, "firstAuthor");
            return (Criteria) this;
        }

        public Criteria andFirstAuthorNotLike(String value) {
            addCriterion("first_author not like", value, "firstAuthor");
            return (Criteria) this;
        }

        public Criteria andFirstAuthorIn(List<String> values) {
            addCriterion("first_author in", values, "firstAuthor");
            return (Criteria) this;
        }

        public Criteria andFirstAuthorNotIn(List<String> values) {
            addCriterion("first_author not in", values, "firstAuthor");
            return (Criteria) this;
        }

        public Criteria andFirstAuthorBetween(String value1, String value2) {
            addCriterion("first_author between", value1, value2, "firstAuthor");
            return (Criteria) this;
        }

        public Criteria andFirstAuthorNotBetween(String value1, String value2) {
            addCriterion("first_author not between", value1, value2, "firstAuthor");
            return (Criteria) this;
        }

        public Criteria andSecondAuthorIsNull() {
            addCriterion("second_author is null");
            return (Criteria) this;
        }

        public Criteria andSecondAuthorIsNotNull() {
            addCriterion("second_author is not null");
            return (Criteria) this;
        }

        public Criteria andSecondAuthorEqualTo(String value) {
            addCriterion("second_author =", value, "secondAuthor");
            return (Criteria) this;
        }

        public Criteria andSecondAuthorNotEqualTo(String value) {
            addCriterion("second_author <>", value, "secondAuthor");
            return (Criteria) this;
        }

        public Criteria andSecondAuthorGreaterThan(String value) {
            addCriterion("second_author >", value, "secondAuthor");
            return (Criteria) this;
        }

        public Criteria andSecondAuthorGreaterThanOrEqualTo(String value) {
            addCriterion("second_author >=", value, "secondAuthor");
            return (Criteria) this;
        }

        public Criteria andSecondAuthorLessThan(String value) {
            addCriterion("second_author <", value, "secondAuthor");
            return (Criteria) this;
        }

        public Criteria andSecondAuthorLessThanOrEqualTo(String value) {
            addCriterion("second_author <=", value, "secondAuthor");
            return (Criteria) this;
        }

        public Criteria andSecondAuthorLike(String value) {
            addCriterion("second_author like", value, "secondAuthor");
            return (Criteria) this;
        }

        public Criteria andSecondAuthorNotLike(String value) {
            addCriterion("second_author not like", value, "secondAuthor");
            return (Criteria) this;
        }

        public Criteria andSecondAuthorIn(List<String> values) {
            addCriterion("second_author in", values, "secondAuthor");
            return (Criteria) this;
        }

        public Criteria andSecondAuthorNotIn(List<String> values) {
            addCriterion("second_author not in", values, "secondAuthor");
            return (Criteria) this;
        }

        public Criteria andSecondAuthorBetween(String value1, String value2) {
            addCriterion("second_author between", value1, value2, "secondAuthor");
            return (Criteria) this;
        }

        public Criteria andSecondAuthorNotBetween(String value1, String value2) {
            addCriterion("second_author not between", value1, value2, "secondAuthor");
            return (Criteria) this;
        }

        public Criteria andThirdAuthorIsNull() {
            addCriterion("third_author is null");
            return (Criteria) this;
        }

        public Criteria andThirdAuthorIsNotNull() {
            addCriterion("third_author is not null");
            return (Criteria) this;
        }

        public Criteria andThirdAuthorEqualTo(String value) {
            addCriterion("third_author =", value, "thirdAuthor");
            return (Criteria) this;
        }

        public Criteria andThirdAuthorNotEqualTo(String value) {
            addCriterion("third_author <>", value, "thirdAuthor");
            return (Criteria) this;
        }

        public Criteria andThirdAuthorGreaterThan(String value) {
            addCriterion("third_author >", value, "thirdAuthor");
            return (Criteria) this;
        }

        public Criteria andThirdAuthorGreaterThanOrEqualTo(String value) {
            addCriterion("third_author >=", value, "thirdAuthor");
            return (Criteria) this;
        }

        public Criteria andThirdAuthorLessThan(String value) {
            addCriterion("third_author <", value, "thirdAuthor");
            return (Criteria) this;
        }

        public Criteria andThirdAuthorLessThanOrEqualTo(String value) {
            addCriterion("third_author <=", value, "thirdAuthor");
            return (Criteria) this;
        }

        public Criteria andThirdAuthorLike(String value) {
            addCriterion("third_author like", value, "thirdAuthor");
            return (Criteria) this;
        }

        public Criteria andThirdAuthorNotLike(String value) {
            addCriterion("third_author not like", value, "thirdAuthor");
            return (Criteria) this;
        }

        public Criteria andThirdAuthorIn(List<String> values) {
            addCriterion("third_author in", values, "thirdAuthor");
            return (Criteria) this;
        }

        public Criteria andThirdAuthorNotIn(List<String> values) {
            addCriterion("third_author not in", values, "thirdAuthor");
            return (Criteria) this;
        }

        public Criteria andThirdAuthorBetween(String value1, String value2) {
            addCriterion("third_author between", value1, value2, "thirdAuthor");
            return (Criteria) this;
        }

        public Criteria andThirdAuthorNotBetween(String value1, String value2) {
            addCriterion("third_author not between", value1, value2, "thirdAuthor");
            return (Criteria) this;
        }

        public Criteria andOtherAuthorsIsNull() {
            addCriterion("other_authors is null");
            return (Criteria) this;
        }

        public Criteria andOtherAuthorsIsNotNull() {
            addCriterion("other_authors is not null");
            return (Criteria) this;
        }

        public Criteria andOtherAuthorsEqualTo(String value) {
            addCriterion("other_authors =", value, "otherAuthors");
            return (Criteria) this;
        }

        public Criteria andOtherAuthorsNotEqualTo(String value) {
            addCriterion("other_authors <>", value, "otherAuthors");
            return (Criteria) this;
        }

        public Criteria andOtherAuthorsGreaterThan(String value) {
            addCriterion("other_authors >", value, "otherAuthors");
            return (Criteria) this;
        }

        public Criteria andOtherAuthorsGreaterThanOrEqualTo(String value) {
            addCriterion("other_authors >=", value, "otherAuthors");
            return (Criteria) this;
        }

        public Criteria andOtherAuthorsLessThan(String value) {
            addCriterion("other_authors <", value, "otherAuthors");
            return (Criteria) this;
        }

        public Criteria andOtherAuthorsLessThanOrEqualTo(String value) {
            addCriterion("other_authors <=", value, "otherAuthors");
            return (Criteria) this;
        }

        public Criteria andOtherAuthorsLike(String value) {
            addCriterion("other_authors like", value, "otherAuthors");
            return (Criteria) this;
        }

        public Criteria andOtherAuthorsNotLike(String value) {
            addCriterion("other_authors not like", value, "otherAuthors");
            return (Criteria) this;
        }

        public Criteria andOtherAuthorsIn(List<String> values) {
            addCriterion("other_authors in", values, "otherAuthors");
            return (Criteria) this;
        }

        public Criteria andOtherAuthorsNotIn(List<String> values) {
            addCriterion("other_authors not in", values, "otherAuthors");
            return (Criteria) this;
        }

        public Criteria andOtherAuthorsBetween(String value1, String value2) {
            addCriterion("other_authors between", value1, value2, "otherAuthors");
            return (Criteria) this;
        }

        public Criteria andOtherAuthorsNotBetween(String value1, String value2) {
            addCriterion("other_authors not between", value1, value2, "otherAuthors");
            return (Criteria) this;
        }

        public Criteria andLevelIsNull() {
            addCriterion("`level` is null");
            return (Criteria) this;
        }

        public Criteria andLevelIsNotNull() {
            addCriterion("`level` is not null");
            return (Criteria) this;
        }

        public Criteria andLevelEqualTo(String value) {
            addCriterion("`level` =", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotEqualTo(String value) {
            addCriterion("`level` <>", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelGreaterThan(String value) {
            addCriterion("`level` >", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelGreaterThanOrEqualTo(String value) {
            addCriterion("`level` >=", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelLessThan(String value) {
            addCriterion("`level` <", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelLessThanOrEqualTo(String value) {
            addCriterion("`level` <=", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelLike(String value) {
            addCriterion("`level` like", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotLike(String value) {
            addCriterion("`level` not like", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelIn(List<String> values) {
            addCriterion("`level` in", values, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotIn(List<String> values) {
            addCriterion("`level` not in", values, "level");
            return (Criteria) this;
        }

        public Criteria andLevelBetween(String value1, String value2) {
            addCriterion("`level` between", value1, value2, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotBetween(String value1, String value2) {
            addCriterion("`level` not between", value1, value2, "level");
            return (Criteria) this;
        }

        public Criteria andTimeIsNull() {
            addCriterion("`time` is null");
            return (Criteria) this;
        }

        public Criteria andTimeIsNotNull() {
            addCriterion("`time` is not null");
            return (Criteria) this;
        }

        public Criteria andTimeEqualTo(String value) {
            addCriterion("`time` =", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotEqualTo(String value) {
            addCriterion("`time` <>", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeGreaterThan(String value) {
            addCriterion("`time` >", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeGreaterThanOrEqualTo(String value) {
            addCriterion("`time` >=", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeLessThan(String value) {
            addCriterion("`time` <", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeLessThanOrEqualTo(String value) {
            addCriterion("`time` <=", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeLike(String value) {
            addCriterion("`time` like", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotLike(String value) {
            addCriterion("`time` not like", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeIn(List<String> values) {
            addCriterion("`time` in", values, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotIn(List<String> values) {
            addCriterion("`time` not in", values, "time");
            return (Criteria) this;
        }

        public Criteria andTimeBetween(String value1, String value2) {
            addCriterion("`time` between", value1, value2, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotBetween(String value1, String value2) {
            addCriterion("`time` not between", value1, value2, "time");
            return (Criteria) this;
        }

        public Criteria andFundsIsNull() {
            addCriterion("funds is null");
            return (Criteria) this;
        }

        public Criteria andFundsIsNotNull() {
            addCriterion("funds is not null");
            return (Criteria) this;
        }

        public Criteria andFundsEqualTo(String value) {
            addCriterion("funds =", value, "funds");
            return (Criteria) this;
        }

        public Criteria andFundsNotEqualTo(String value) {
            addCriterion("funds <>", value, "funds");
            return (Criteria) this;
        }

        public Criteria andFundsGreaterThan(String value) {
            addCriterion("funds >", value, "funds");
            return (Criteria) this;
        }

        public Criteria andFundsGreaterThanOrEqualTo(String value) {
            addCriterion("funds >=", value, "funds");
            return (Criteria) this;
        }

        public Criteria andFundsLessThan(String value) {
            addCriterion("funds <", value, "funds");
            return (Criteria) this;
        }

        public Criteria andFundsLessThanOrEqualTo(String value) {
            addCriterion("funds <=", value, "funds");
            return (Criteria) this;
        }

        public Criteria andFundsLike(String value) {
            addCriterion("funds like", value, "funds");
            return (Criteria) this;
        }

        public Criteria andFundsNotLike(String value) {
            addCriterion("funds not like", value, "funds");
            return (Criteria) this;
        }

        public Criteria andFundsIn(List<String> values) {
            addCriterion("funds in", values, "funds");
            return (Criteria) this;
        }

        public Criteria andFundsNotIn(List<String> values) {
            addCriterion("funds not in", values, "funds");
            return (Criteria) this;
        }

        public Criteria andFundsBetween(String value1, String value2) {
            addCriterion("funds between", value1, value2, "funds");
            return (Criteria) this;
        }

        public Criteria andFundsNotBetween(String value1, String value2) {
            addCriterion("funds not between", value1, value2, "funds");
            return (Criteria) this;
        }

        public Criteria andProcessIsNull() {
            addCriterion("`process` is null");
            return (Criteria) this;
        }

        public Criteria andProcessIsNotNull() {
            addCriterion("`process` is not null");
            return (Criteria) this;
        }

        public Criteria andProcessEqualTo(String value) {
            addCriterion("`process` =", value, "process");
            return (Criteria) this;
        }

        public Criteria andProcessNotEqualTo(String value) {
            addCriterion("`process` <>", value, "process");
            return (Criteria) this;
        }

        public Criteria andProcessGreaterThan(String value) {
            addCriterion("`process` >", value, "process");
            return (Criteria) this;
        }

        public Criteria andProcessGreaterThanOrEqualTo(String value) {
            addCriterion("`process` >=", value, "process");
            return (Criteria) this;
        }

        public Criteria andProcessLessThan(String value) {
            addCriterion("`process` <", value, "process");
            return (Criteria) this;
        }

        public Criteria andProcessLessThanOrEqualTo(String value) {
            addCriterion("`process` <=", value, "process");
            return (Criteria) this;
        }

        public Criteria andProcessLike(String value) {
            addCriterion("`process` like", value, "process");
            return (Criteria) this;
        }

        public Criteria andProcessNotLike(String value) {
            addCriterion("`process` not like", value, "process");
            return (Criteria) this;
        }

        public Criteria andProcessIn(List<String> values) {
            addCriterion("`process` in", values, "process");
            return (Criteria) this;
        }

        public Criteria andProcessNotIn(List<String> values) {
            addCriterion("`process` not in", values, "process");
            return (Criteria) this;
        }

        public Criteria andProcessBetween(String value1, String value2) {
            addCriterion("`process` between", value1, value2, "process");
            return (Criteria) this;
        }

        public Criteria andProcessNotBetween(String value1, String value2) {
            addCriterion("`process` not between", value1, value2, "process");
            return (Criteria) this;
        }

        public Criteria andResourceIsNull() {
            addCriterion("`resource` is null");
            return (Criteria) this;
        }

        public Criteria andResourceIsNotNull() {
            addCriterion("`resource` is not null");
            return (Criteria) this;
        }

        public Criteria andResourceEqualTo(String value) {
            addCriterion("`resource` =", value, "resource");
            return (Criteria) this;
        }

        public Criteria andResourceNotEqualTo(String value) {
            addCriterion("`resource` <>", value, "resource");
            return (Criteria) this;
        }

        public Criteria andResourceGreaterThan(String value) {
            addCriterion("`resource` >", value, "resource");
            return (Criteria) this;
        }

        public Criteria andResourceGreaterThanOrEqualTo(String value) {
            addCriterion("`resource` >=", value, "resource");
            return (Criteria) this;
        }

        public Criteria andResourceLessThan(String value) {
            addCriterion("`resource` <", value, "resource");
            return (Criteria) this;
        }

        public Criteria andResourceLessThanOrEqualTo(String value) {
            addCriterion("`resource` <=", value, "resource");
            return (Criteria) this;
        }

        public Criteria andResourceLike(String value) {
            addCriterion("`resource` like", value, "resource");
            return (Criteria) this;
        }

        public Criteria andResourceNotLike(String value) {
            addCriterion("`resource` not like", value, "resource");
            return (Criteria) this;
        }

        public Criteria andResourceIn(List<String> values) {
            addCriterion("`resource` in", values, "resource");
            return (Criteria) this;
        }

        public Criteria andResourceNotIn(List<String> values) {
            addCriterion("`resource` not in", values, "resource");
            return (Criteria) this;
        }

        public Criteria andResourceBetween(String value1, String value2) {
            addCriterion("`resource` between", value1, value2, "resource");
            return (Criteria) this;
        }

        public Criteria andResourceNotBetween(String value1, String value2) {
            addCriterion("`resource` not between", value1, value2, "resource");
            return (Criteria) this;
        }

        public Criteria andApplicationIsNull() {
            addCriterion("`application` is null");
            return (Criteria) this;
        }

        public Criteria andApplicationIsNotNull() {
            addCriterion("`application` is not null");
            return (Criteria) this;
        }

        public Criteria andApplicationEqualTo(String value) {
            addCriterion("`application` =", value, "application");
            return (Criteria) this;
        }

        public Criteria andApplicationNotEqualTo(String value) {
            addCriterion("`application` <>", value, "application");
            return (Criteria) this;
        }

        public Criteria andApplicationGreaterThan(String value) {
            addCriterion("`application` >", value, "application");
            return (Criteria) this;
        }

        public Criteria andApplicationGreaterThanOrEqualTo(String value) {
            addCriterion("`application` >=", value, "application");
            return (Criteria) this;
        }

        public Criteria andApplicationLessThan(String value) {
            addCriterion("`application` <", value, "application");
            return (Criteria) this;
        }

        public Criteria andApplicationLessThanOrEqualTo(String value) {
            addCriterion("`application` <=", value, "application");
            return (Criteria) this;
        }

        public Criteria andApplicationLike(String value) {
            addCriterion("`application` like", value, "application");
            return (Criteria) this;
        }

        public Criteria andApplicationNotLike(String value) {
            addCriterion("`application` not like", value, "application");
            return (Criteria) this;
        }

        public Criteria andApplicationIn(List<String> values) {
            addCriterion("`application` in", values, "application");
            return (Criteria) this;
        }

        public Criteria andApplicationNotIn(List<String> values) {
            addCriterion("`application` not in", values, "application");
            return (Criteria) this;
        }

        public Criteria andApplicationBetween(String value1, String value2) {
            addCriterion("`application` between", value1, value2, "application");
            return (Criteria) this;
        }

        public Criteria andApplicationNotBetween(String value1, String value2) {
            addCriterion("`application` not between", value1, value2, "application");
            return (Criteria) this;
        }

        public Criteria andOthermsgIsNull() {
            addCriterion("othermsg is null");
            return (Criteria) this;
        }

        public Criteria andOthermsgIsNotNull() {
            addCriterion("othermsg is not null");
            return (Criteria) this;
        }

        public Criteria andOthermsgEqualTo(String value) {
            addCriterion("othermsg =", value, "othermsg");
            return (Criteria) this;
        }

        public Criteria andOthermsgNotEqualTo(String value) {
            addCriterion("othermsg <>", value, "othermsg");
            return (Criteria) this;
        }

        public Criteria andOthermsgGreaterThan(String value) {
            addCriterion("othermsg >", value, "othermsg");
            return (Criteria) this;
        }

        public Criteria andOthermsgGreaterThanOrEqualTo(String value) {
            addCriterion("othermsg >=", value, "othermsg");
            return (Criteria) this;
        }

        public Criteria andOthermsgLessThan(String value) {
            addCriterion("othermsg <", value, "othermsg");
            return (Criteria) this;
        }

        public Criteria andOthermsgLessThanOrEqualTo(String value) {
            addCriterion("othermsg <=", value, "othermsg");
            return (Criteria) this;
        }

        public Criteria andOthermsgLike(String value) {
            addCriterion("othermsg like", value, "othermsg");
            return (Criteria) this;
        }

        public Criteria andOthermsgNotLike(String value) {
            addCriterion("othermsg not like", value, "othermsg");
            return (Criteria) this;
        }

        public Criteria andOthermsgIn(List<String> values) {
            addCriterion("othermsg in", values, "othermsg");
            return (Criteria) this;
        }

        public Criteria andOthermsgNotIn(List<String> values) {
            addCriterion("othermsg not in", values, "othermsg");
            return (Criteria) this;
        }

        public Criteria andOthermsgBetween(String value1, String value2) {
            addCriterion("othermsg between", value1, value2, "othermsg");
            return (Criteria) this;
        }

        public Criteria andOthermsgNotBetween(String value1, String value2) {
            addCriterion("othermsg not between", value1, value2, "othermsg");
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