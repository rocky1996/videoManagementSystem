package com.example.videomanagementsystem.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class VideoSystemTaskExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public VideoSystemTaskExample() {
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

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Integer value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Integer> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andTaskNameIsNull() {
            addCriterion("task_name is null");
            return (Criteria) this;
        }

        public Criteria andTaskNameIsNotNull() {
            addCriterion("task_name is not null");
            return (Criteria) this;
        }

        public Criteria andTaskNameEqualTo(String value) {
            addCriterion("task_name =", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameNotEqualTo(String value) {
            addCriterion("task_name <>", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameGreaterThan(String value) {
            addCriterion("task_name >", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameGreaterThanOrEqualTo(String value) {
            addCriterion("task_name >=", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameLessThan(String value) {
            addCriterion("task_name <", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameLessThanOrEqualTo(String value) {
            addCriterion("task_name <=", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameLike(String value) {
            addCriterion("task_name like", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameNotLike(String value) {
            addCriterion("task_name not like", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameIn(List<String> values) {
            addCriterion("task_name in", values, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameNotIn(List<String> values) {
            addCriterion("task_name not in", values, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameBetween(String value1, String value2) {
            addCriterion("task_name between", value1, value2, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameNotBetween(String value1, String value2) {
            addCriterion("task_name not between", value1, value2, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskTypeIsNull() {
            addCriterion("task_type is null");
            return (Criteria) this;
        }

        public Criteria andTaskTypeIsNotNull() {
            addCriterion("task_type is not null");
            return (Criteria) this;
        }

        public Criteria andTaskTypeEqualTo(Integer value) {
            addCriterion("task_type =", value, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeNotEqualTo(Integer value) {
            addCriterion("task_type <>", value, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeGreaterThan(Integer value) {
            addCriterion("task_type >", value, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("task_type >=", value, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeLessThan(Integer value) {
            addCriterion("task_type <", value, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeLessThanOrEqualTo(Integer value) {
            addCriterion("task_type <=", value, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeIn(List<Integer> values) {
            addCriterion("task_type in", values, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeNotIn(List<Integer> values) {
            addCriterion("task_type not in", values, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeBetween(Integer value1, Integer value2) {
            addCriterion("task_type between", value1, value2, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("task_type not between", value1, value2, "taskType");
            return (Criteria) this;
        }

        public Criteria andGatherVideoStartTimeIsNull() {
            addCriterion("gather_video_start_time is null");
            return (Criteria) this;
        }

        public Criteria andGatherVideoStartTimeIsNotNull() {
            addCriterion("gather_video_start_time is not null");
            return (Criteria) this;
        }

        public Criteria andGatherVideoStartTimeEqualTo(Date value) {
            addCriterion("gather_video_start_time =", value, "gatherVideoStartTime");
            return (Criteria) this;
        }

        public Criteria andGatherVideoStartTimeNotEqualTo(Date value) {
            addCriterion("gather_video_start_time <>", value, "gatherVideoStartTime");
            return (Criteria) this;
        }

        public Criteria andGatherVideoStartTimeGreaterThan(Date value) {
            addCriterion("gather_video_start_time >", value, "gatherVideoStartTime");
            return (Criteria) this;
        }

        public Criteria andGatherVideoStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("gather_video_start_time >=", value, "gatherVideoStartTime");
            return (Criteria) this;
        }

        public Criteria andGatherVideoStartTimeLessThan(Date value) {
            addCriterion("gather_video_start_time <", value, "gatherVideoStartTime");
            return (Criteria) this;
        }

        public Criteria andGatherVideoStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("gather_video_start_time <=", value, "gatherVideoStartTime");
            return (Criteria) this;
        }

        public Criteria andGatherVideoStartTimeIn(List<Date> values) {
            addCriterion("gather_video_start_time in", values, "gatherVideoStartTime");
            return (Criteria) this;
        }

        public Criteria andGatherVideoStartTimeNotIn(List<Date> values) {
            addCriterion("gather_video_start_time not in", values, "gatherVideoStartTime");
            return (Criteria) this;
        }

        public Criteria andGatherVideoStartTimeBetween(Date value1, Date value2) {
            addCriterion("gather_video_start_time between", value1, value2, "gatherVideoStartTime");
            return (Criteria) this;
        }

        public Criteria andGatherVideoStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("gather_video_start_time not between", value1, value2, "gatherVideoStartTime");
            return (Criteria) this;
        }

        public Criteria andGatherVideoEndTimeIsNull() {
            addCriterion("gather_video_end_time is null");
            return (Criteria) this;
        }

        public Criteria andGatherVideoEndTimeIsNotNull() {
            addCriterion("gather_video_end_time is not null");
            return (Criteria) this;
        }

        public Criteria andGatherVideoEndTimeEqualTo(Date value) {
            addCriterion("gather_video_end_time =", value, "gatherVideoEndTime");
            return (Criteria) this;
        }

        public Criteria andGatherVideoEndTimeNotEqualTo(Date value) {
            addCriterion("gather_video_end_time <>", value, "gatherVideoEndTime");
            return (Criteria) this;
        }

        public Criteria andGatherVideoEndTimeGreaterThan(Date value) {
            addCriterion("gather_video_end_time >", value, "gatherVideoEndTime");
            return (Criteria) this;
        }

        public Criteria andGatherVideoEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("gather_video_end_time >=", value, "gatherVideoEndTime");
            return (Criteria) this;
        }

        public Criteria andGatherVideoEndTimeLessThan(Date value) {
            addCriterion("gather_video_end_time <", value, "gatherVideoEndTime");
            return (Criteria) this;
        }

        public Criteria andGatherVideoEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("gather_video_end_time <=", value, "gatherVideoEndTime");
            return (Criteria) this;
        }

        public Criteria andGatherVideoEndTimeIn(List<Date> values) {
            addCriterion("gather_video_end_time in", values, "gatherVideoEndTime");
            return (Criteria) this;
        }

        public Criteria andGatherVideoEndTimeNotIn(List<Date> values) {
            addCriterion("gather_video_end_time not in", values, "gatherVideoEndTime");
            return (Criteria) this;
        }

        public Criteria andGatherVideoEndTimeBetween(Date value1, Date value2) {
            addCriterion("gather_video_end_time between", value1, value2, "gatherVideoEndTime");
            return (Criteria) this;
        }

        public Criteria andGatherVideoEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("gather_video_end_time not between", value1, value2, "gatherVideoEndTime");
            return (Criteria) this;
        }

        public Criteria andGatherVideoTimeIsNull() {
            addCriterion("gather_video_time is null");
            return (Criteria) this;
        }

        public Criteria andGatherVideoTimeIsNotNull() {
            addCriterion("gather_video_time is not null");
            return (Criteria) this;
        }

        public Criteria andGatherVideoTimeEqualTo(Date value) {
            addCriterion("gather_video_time =", value, "gatherVideoTime");
            return (Criteria) this;
        }

        public Criteria andGatherVideoTimeNotEqualTo(Date value) {
            addCriterion("gather_video_time <>", value, "gatherVideoTime");
            return (Criteria) this;
        }

        public Criteria andGatherVideoTimeGreaterThan(Date value) {
            addCriterion("gather_video_time >", value, "gatherVideoTime");
            return (Criteria) this;
        }

        public Criteria andGatherVideoTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("gather_video_time >=", value, "gatherVideoTime");
            return (Criteria) this;
        }

        public Criteria andGatherVideoTimeLessThan(Date value) {
            addCriterion("gather_video_time <", value, "gatherVideoTime");
            return (Criteria) this;
        }

        public Criteria andGatherVideoTimeLessThanOrEqualTo(Date value) {
            addCriterion("gather_video_time <=", value, "gatherVideoTime");
            return (Criteria) this;
        }

        public Criteria andGatherVideoTimeIn(List<Date> values) {
            addCriterion("gather_video_time in", values, "gatherVideoTime");
            return (Criteria) this;
        }

        public Criteria andGatherVideoTimeNotIn(List<Date> values) {
            addCriterion("gather_video_time not in", values, "gatherVideoTime");
            return (Criteria) this;
        }

        public Criteria andGatherVideoTimeBetween(Date value1, Date value2) {
            addCriterion("gather_video_time between", value1, value2, "gatherVideoTime");
            return (Criteria) this;
        }

        public Criteria andGatherVideoTimeNotBetween(Date value1, Date value2) {
            addCriterion("gather_video_time not between", value1, value2, "gatherVideoTime");
            return (Criteria) this;
        }

        public Criteria andPushTimeIsNull() {
            addCriterion("push_time is null");
            return (Criteria) this;
        }

        public Criteria andPushTimeIsNotNull() {
            addCriterion("push_time is not null");
            return (Criteria) this;
        }

        public Criteria andPushTimeEqualTo(Date value) {
            addCriterion("push_time =", value, "pushTime");
            return (Criteria) this;
        }

        public Criteria andPushTimeNotEqualTo(Date value) {
            addCriterion("push_time <>", value, "pushTime");
            return (Criteria) this;
        }

        public Criteria andPushTimeGreaterThan(Date value) {
            addCriterion("push_time >", value, "pushTime");
            return (Criteria) this;
        }

        public Criteria andPushTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("push_time >=", value, "pushTime");
            return (Criteria) this;
        }

        public Criteria andPushTimeLessThan(Date value) {
            addCriterion("push_time <", value, "pushTime");
            return (Criteria) this;
        }

        public Criteria andPushTimeLessThanOrEqualTo(Date value) {
            addCriterion("push_time <=", value, "pushTime");
            return (Criteria) this;
        }

        public Criteria andPushTimeIn(List<Date> values) {
            addCriterion("push_time in", values, "pushTime");
            return (Criteria) this;
        }

        public Criteria andPushTimeNotIn(List<Date> values) {
            addCriterion("push_time not in", values, "pushTime");
            return (Criteria) this;
        }

        public Criteria andPushTimeBetween(Date value1, Date value2) {
            addCriterion("push_time between", value1, value2, "pushTime");
            return (Criteria) this;
        }

        public Criteria andPushTimeNotBetween(Date value1, Date value2) {
            addCriterion("push_time not between", value1, value2, "pushTime");
            return (Criteria) this;
        }

        public Criteria andGatherTypeIsNull() {
            addCriterion("gather_type is null");
            return (Criteria) this;
        }

        public Criteria andGatherTypeIsNotNull() {
            addCriterion("gather_type is not null");
            return (Criteria) this;
        }

        public Criteria andGatherTypeEqualTo(Integer value) {
            addCriterion("gather_type =", value, "gatherType");
            return (Criteria) this;
        }

        public Criteria andGatherTypeNotEqualTo(Integer value) {
            addCriterion("gather_type <>", value, "gatherType");
            return (Criteria) this;
        }

        public Criteria andGatherTypeGreaterThan(Integer value) {
            addCriterion("gather_type >", value, "gatherType");
            return (Criteria) this;
        }

        public Criteria andGatherTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("gather_type >=", value, "gatherType");
            return (Criteria) this;
        }

        public Criteria andGatherTypeLessThan(Integer value) {
            addCriterion("gather_type <", value, "gatherType");
            return (Criteria) this;
        }

        public Criteria andGatherTypeLessThanOrEqualTo(Integer value) {
            addCriterion("gather_type <=", value, "gatherType");
            return (Criteria) this;
        }

        public Criteria andGatherTypeIn(List<Integer> values) {
            addCriterion("gather_type in", values, "gatherType");
            return (Criteria) this;
        }

        public Criteria andGatherTypeNotIn(List<Integer> values) {
            addCriterion("gather_type not in", values, "gatherType");
            return (Criteria) this;
        }

        public Criteria andGatherTypeBetween(Integer value1, Integer value2) {
            addCriterion("gather_type between", value1, value2, "gatherType");
            return (Criteria) this;
        }

        public Criteria andGatherTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("gather_type not between", value1, value2, "gatherType");
            return (Criteria) this;
        }

        public Criteria andIsProofreadingIsNull() {
            addCriterion("is_proofreading is null");
            return (Criteria) this;
        }

        public Criteria andIsProofreadingIsNotNull() {
            addCriterion("is_proofreading is not null");
            return (Criteria) this;
        }

        public Criteria andIsProofreadingEqualTo(Integer value) {
            addCriterion("is_proofreading =", value, "isProofreading");
            return (Criteria) this;
        }

        public Criteria andIsProofreadingNotEqualTo(Integer value) {
            addCriterion("is_proofreading <>", value, "isProofreading");
            return (Criteria) this;
        }

        public Criteria andIsProofreadingGreaterThan(Integer value) {
            addCriterion("is_proofreading >", value, "isProofreading");
            return (Criteria) this;
        }

        public Criteria andIsProofreadingGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_proofreading >=", value, "isProofreading");
            return (Criteria) this;
        }

        public Criteria andIsProofreadingLessThan(Integer value) {
            addCriterion("is_proofreading <", value, "isProofreading");
            return (Criteria) this;
        }

        public Criteria andIsProofreadingLessThanOrEqualTo(Integer value) {
            addCriterion("is_proofreading <=", value, "isProofreading");
            return (Criteria) this;
        }

        public Criteria andIsProofreadingIn(List<Integer> values) {
            addCriterion("is_proofreading in", values, "isProofreading");
            return (Criteria) this;
        }

        public Criteria andIsProofreadingNotIn(List<Integer> values) {
            addCriterion("is_proofreading not in", values, "isProofreading");
            return (Criteria) this;
        }

        public Criteria andIsProofreadingBetween(Integer value1, Integer value2) {
            addCriterion("is_proofreading between", value1, value2, "isProofreading");
            return (Criteria) this;
        }

        public Criteria andIsProofreadingNotBetween(Integer value1, Integer value2) {
            addCriterion("is_proofreading not between", value1, value2, "isProofreading");
            return (Criteria) this;
        }

        public Criteria andTaskOpenStatusIsNull() {
            addCriterion("task_open_status is null");
            return (Criteria) this;
        }

        public Criteria andTaskOpenStatusIsNotNull() {
            addCriterion("task_open_status is not null");
            return (Criteria) this;
        }

        public Criteria andTaskOpenStatusEqualTo(Integer value) {
            addCriterion("task_open_status =", value, "taskOpenStatus");
            return (Criteria) this;
        }

        public Criteria andTaskOpenStatusNotEqualTo(Integer value) {
            addCriterion("task_open_status <>", value, "taskOpenStatus");
            return (Criteria) this;
        }

        public Criteria andTaskOpenStatusGreaterThan(Integer value) {
            addCriterion("task_open_status >", value, "taskOpenStatus");
            return (Criteria) this;
        }

        public Criteria andTaskOpenStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("task_open_status >=", value, "taskOpenStatus");
            return (Criteria) this;
        }

        public Criteria andTaskOpenStatusLessThan(Integer value) {
            addCriterion("task_open_status <", value, "taskOpenStatus");
            return (Criteria) this;
        }

        public Criteria andTaskOpenStatusLessThanOrEqualTo(Integer value) {
            addCriterion("task_open_status <=", value, "taskOpenStatus");
            return (Criteria) this;
        }

        public Criteria andTaskOpenStatusIn(List<Integer> values) {
            addCriterion("task_open_status in", values, "taskOpenStatus");
            return (Criteria) this;
        }

        public Criteria andTaskOpenStatusNotIn(List<Integer> values) {
            addCriterion("task_open_status not in", values, "taskOpenStatus");
            return (Criteria) this;
        }

        public Criteria andTaskOpenStatusBetween(Integer value1, Integer value2) {
            addCriterion("task_open_status between", value1, value2, "taskOpenStatus");
            return (Criteria) this;
        }

        public Criteria andTaskOpenStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("task_open_status not between", value1, value2, "taskOpenStatus");
            return (Criteria) this;
        }

        public Criteria andTaskStatusIsNull() {
            addCriterion("task_status is null");
            return (Criteria) this;
        }

        public Criteria andTaskStatusIsNotNull() {
            addCriterion("task_status is not null");
            return (Criteria) this;
        }

        public Criteria andTaskStatusEqualTo(Integer value) {
            addCriterion("task_status =", value, "taskStatus");
            return (Criteria) this;
        }

        public Criteria andTaskStatusNotEqualTo(Integer value) {
            addCriterion("task_status <>", value, "taskStatus");
            return (Criteria) this;
        }

        public Criteria andTaskStatusGreaterThan(Integer value) {
            addCriterion("task_status >", value, "taskStatus");
            return (Criteria) this;
        }

        public Criteria andTaskStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("task_status >=", value, "taskStatus");
            return (Criteria) this;
        }

        public Criteria andTaskStatusLessThan(Integer value) {
            addCriterion("task_status <", value, "taskStatus");
            return (Criteria) this;
        }

        public Criteria andTaskStatusLessThanOrEqualTo(Integer value) {
            addCriterion("task_status <=", value, "taskStatus");
            return (Criteria) this;
        }

        public Criteria andTaskStatusIn(List<Integer> values) {
            addCriterion("task_status in", values, "taskStatus");
            return (Criteria) this;
        }

        public Criteria andTaskStatusNotIn(List<Integer> values) {
            addCriterion("task_status not in", values, "taskStatus");
            return (Criteria) this;
        }

        public Criteria andTaskStatusBetween(Integer value1, Integer value2) {
            addCriterion("task_status between", value1, value2, "taskStatus");
            return (Criteria) this;
        }

        public Criteria andTaskStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("task_status not between", value1, value2, "taskStatus");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIsNull() {
            addCriterion("is_delete is null");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIsNotNull() {
            addCriterion("is_delete is not null");
            return (Criteria) this;
        }

        public Criteria andIsDeleteEqualTo(Integer value) {
            addCriterion("is_delete =", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotEqualTo(Integer value) {
            addCriterion("is_delete <>", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteGreaterThan(Integer value) {
            addCriterion("is_delete >", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_delete >=", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteLessThan(Integer value) {
            addCriterion("is_delete <", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteLessThanOrEqualTo(Integer value) {
            addCriterion("is_delete <=", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIn(List<Integer> values) {
            addCriterion("is_delete in", values, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotIn(List<Integer> values) {
            addCriterion("is_delete not in", values, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteBetween(Integer value1, Integer value2) {
            addCriterion("is_delete between", value1, value2, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotBetween(Integer value1, Integer value2) {
            addCriterion("is_delete not between", value1, value2, "isDelete");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
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