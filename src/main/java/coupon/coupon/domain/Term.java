package coupon.coupon.domain;

import java.time.LocalDate;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import coupon.coupon.CouponException;

@Embeddable
public class Term {

    private static final String TERM_MESSAGE = "종료일이 시작일보다 앞설 수 없습니다.";

    @Column(nullable = false)
    private LocalDate startAt;

    @Column(nullable = false)
    private LocalDate endAt;

    protected Term() {
    }

    public Term(LocalDate startAt, LocalDate endAt) {
        validateTerm(startAt, endAt);
        this.startAt = startAt;
        this.endAt = endAt;
    }

    private void validateTerm(LocalDate startAt, LocalDate endAt) {
        if (endAt.isBefore(startAt)) {
            throw new CouponException(TERM_MESSAGE);
        }
    }
}
