package com.server.back.domain.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Data
public class Region {

    @Id
    private String regionCode;

    private String sidoName;

    private String gugunName;

    public Region(String regionCode, String sidoName, String gugunName) {
        this.regionCode = regionCode;
        this.sidoName = sidoName;
        this.gugunName = gugunName;
    }
}
