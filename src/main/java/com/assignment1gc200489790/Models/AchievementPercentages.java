package com.assignment1gc200489790.Models;
/*
 * Name: Arin Dhiman
 * Student num: 200489790
 * Date: 15 OCT 2022
 * Description: Model class specifically for mapping API result body
 */

public class AchievementPercentages {
    private Achievement[] achievements;

    /**
     * default constructor for Jackson library to instantiate an achievement object from JSON feed
     */
    public AchievementPercentages() {
    }

    /**
     *  All args constructor just in case
     */
    public AchievementPercentages(Achievement[] achievements) {
        this.achievements = achievements;
    }

    /**
     * Getter
     */
    public Achievement[] getAchievements() {
        return achievements;
    }

    /**
     * Setter
     */
    public void setAchievements(Achievement[] achievements) {
        this.achievements = achievements;
    }
}
