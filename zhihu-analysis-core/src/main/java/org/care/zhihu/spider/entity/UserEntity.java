package org.care.zhihu.spider.entity;

import org.care.zhihu.spider.dao.base.DataEntity;

/**
 * 知乎用户基础信息类
 * Created by van persie on 2017/2/15.
 */
public class UserEntity extends DataEntity<UserEntity>{
    private String userName;
    private String userSex;
    private String homePage; //主页
    private String userImage; //用户头像URL地址
    private String selfIntroduction; //一句话介绍自己
    private String home; //居住地,可多个
    private String industry;//所在行业
    private String careerExperience; //职业经历
    private String educationalExperience; //教育经历
    private String personalProfile; //个人简介
    private String following;
    private String followers;
    private String lives; //举办过的LIVE
    private String followingTopics;
    private String followingColumn;
    private String followingQuestions;
    private String followingCollections;
    private String certificationInfo;
    private String zhihuCollection;
    private String getThanks;
    private String getCollections;
    private String getApproval;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public String getHomePage() {
        return homePage;
    }

    public void setHomePage(String homePage) {
        this.homePage = homePage;
    }

    public String getUserImage() {
        return userImage;
    }

    public void setUserImage(String userImage) {
        this.userImage = userImage;
    }

    public String getSelfIntroduction() {
        return selfIntroduction;
    }

    public void setSelfIntroduction(String selfIntroduction) {
        this.selfIntroduction = selfIntroduction;
    }

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getCareerExperience() {
        return careerExperience;
    }

    public void setCareerExperience(String careerExperience) {
        this.careerExperience = careerExperience;
    }

    public String getEducationalExperience() {
        return educationalExperience;
    }

    public void setEducationalExperience(String educationalExperience) {
        this.educationalExperience = educationalExperience;
    }

    public String getPersonalProfile() {
        return personalProfile;
    }

    public void setPersonalProfile(String personalProfile) {
        this.personalProfile = personalProfile;
    }

    public String getFollowing() {
        return following;
    }

    public void setFollowing(String following) {
        this.following = following;
    }

    public String getFollowers() {
        return followers;
    }

    public void setFollowers(String followers) {
        this.followers = followers;
    }

    public String getLives() {
        return lives;
    }

    public void setLives(String lives) {
        this.lives = lives;
    }

    public String getFollowingTopics() {
        return followingTopics;
    }

    public void setFollowingTopics(String followingTopics) {
        this.followingTopics = followingTopics;
    }

    public String getFollowingColumn() {
        return followingColumn;
    }

    public void setFollowingColumn(String followingColumn) {
        this.followingColumn = followingColumn;
    }

    public String getFollowingQuestions() {
        return followingQuestions;
    }

    public void setFollowingQuestions(String followingQuestions) {
        this.followingQuestions = followingQuestions;
    }

    public String getFollowingCollections() {
        return followingCollections;
    }

    public void setFollowingCollections(String followingCollections) {
        this.followingCollections = followingCollections;
    }

    public String getCertificationInfo() {
        return certificationInfo;
    }

    public void setCertificationInfo(String certificationInfo) {
        this.certificationInfo = certificationInfo;
    }

    public String getZhihuCollection() {
        return zhihuCollection;
    }

    public void setZhihuCollection(String zhihuCollection) {
        this.zhihuCollection = zhihuCollection;
    }

    public String getGetThanks() {
        return getThanks;
    }

    public void setGetThanks(String getThanks) {
        this.getThanks = getThanks;
    }

    public String getGetCollections() {
        return getCollections;
    }

    public void setGetCollections(String getCollections) {
        this.getCollections = getCollections;
    }

    public String getGetApproval() {
        return getApproval;
    }

    public void setGetApproval(String getApproval) {
        this.getApproval = getApproval;
    }

}
