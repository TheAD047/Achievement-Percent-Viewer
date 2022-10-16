package com.assignment1gc200489790.Models;
/*
 * Name: Arin Dhiman
 * Student num: 200489790
 * Date: 15 OCT 2022
 * Description: Model specifically for mapping the API result body
 */

import com.fasterxml.jackson.annotation.JsonProperty;

public class ApiResponse {
    @JsonProperty("achievementpercentages")
    private AchievementPercentages achievementPercentages;

    /**
     * Getter
     */
    public AchievementPercentages getAchievementPercentages() {
        return achievementPercentages;
    }

    /**
     * Setter
     */
    public void setAchievementPercentages(AchievementPercentages achievementPercentages) {
        this.achievementPercentages = achievementPercentages;
    }
}
