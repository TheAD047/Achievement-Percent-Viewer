package com.assignment1gc200489790.Models;

import com.assignment1gc200489790.Models.Achievement;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

public class ApiResponse {
    @JsonProperty("achievementpercentages")
    private AchievementPercentages achievementPercentages;

    public AchievementPercentages getAchievementPercentages() {
        return achievementPercentages;
    }

    public void setAchievementPercentages(AchievementPercentages achievementPercentages) {
        this.achievementPercentages = achievementPercentages;
    }
}
