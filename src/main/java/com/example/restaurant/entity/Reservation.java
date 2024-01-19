package com.example.restaurant.entity;
import com.example.restaurant.entity.Restaurant;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;


/*
// 0.
// 예약 테이블을 만들고
// 예약 생성 + 예약 전체 조회
table reservation {
  id int pk
  restaurant_id int [ref:> restaurant.id]
  date int
  // 1.
  // restaurant.open_hours <= reserve_hour
  // restaurant.close_hours > reserve_hour
  reserve_hour int
  people int

  // 2.
  // reserve_hour + duration <= restaurant.close_hours
  duration int
}
// 3.
// 예약 가능 여부를 판단할때
// 해당 date의
// reserve_hour + duration에 해당한 시간은 다시 예약에 겹침이 불가함
 */
@Getter
@Entity
@NoArgsConstructor
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // 다른 날임을 구분하기 위한 임의 데이터
    private Integer date;
    // 예약 시작 시작
    private Integer reserveHour;
    // 예약 인원 수
    private Integer people;
    // 총 머물 시간
    private Integer duration;

    @ManyToOne
    private Restaurant restaurant;

    public Reservation(
            Integer date,
            Integer reserveHour,
            Integer people,
            Integer duration,
            Restaurant restaurant
    ) {
        this.date = date;
        this.reserveHour = reserveHour;
        this.people = people;
        this.duration = duration;
        this.restaurant = restaurant;
    }
}