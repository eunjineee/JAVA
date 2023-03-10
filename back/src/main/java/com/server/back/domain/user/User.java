package com.server.back.domain.user;

import com.server.back.jwt.refreshToken.RefreshToken;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity @Data
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="user_id")
    private Long userid;//우리 pk

    private String username; //네이버 id pk
    private String password;
    private String nickname;
    private String profile;
    private String comment;
    private String gender;
    private String birth;
    private Double manner;
    private Integer point;
    private Integer is_ban;
    private Integer report_point;
    private String role; //USER,ADMIN 게 넣을것이다.
    private LocalDateTime time;


    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "refreshTokenId")
    private RefreshToken jwtRefreshToken;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "region")
    private Region region;

    @Builder
    public User(Long userid, String username, String password, String nickname, String profile, String comment,
                String gender, String birth, Double manner, Integer point, Integer is_ban, Integer report_point,
                String role,LocalDateTime time, Region region, RefreshToken jwtRefreshToken) {
        this.userid = userid;
        this.username = username;
        this.password = password;
        this.nickname = nickname;
        this.profile = profile;
        this.comment = comment;
        this.gender = gender;
        this.birth = birth;
        this.manner = manner;
        this.point = point;
        this.is_ban = is_ban;
        this.report_point = report_point;
        this.role = role;
        this.time = time;
        this.region = region;
        this.jwtRefreshToken = jwtRefreshToken;
    }


    /**
     *  refresh 생성자, setter
     */
    public void createRefreshToken(RefreshToken refreshToken) {
        this.jwtRefreshToken = refreshToken;
    }
    public void SetRefreshToken(String refreshToken) {
        this.jwtRefreshToken.setRefreshToken(refreshToken);
    }

    /**
     * 사용자가 다양한 권한을 가지고 있을수 있음
     */
    public List<String> getRoleList() {
        if(this.role.length()>0) {
            return Arrays.asList(this.role.split(","));
        }
        return new ArrayList<>();
    }
}
