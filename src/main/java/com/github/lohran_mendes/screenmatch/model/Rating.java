package com.github.lohran_mendes.screenmatch.model;

import com.google.gson.annotations.SerializedName;

public record Rating(@SerializedName("Source") String fonte, @SerializedName("Value") String valor) {
}
