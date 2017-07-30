import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;

public class Meetup {

    private final LocalDate firstDayOfMonth;

    public Meetup(int month, int year) {
        firstDayOfMonth = LocalDate.of(year, month, 1);
    }

    public LocalDate day(DayOfWeek aimedDayOfWeek, MeetupSchedule meetupSchedule) {
        switch (meetupSchedule) {
            case LAST:
                return firstDayOfMonth.with(TemporalAdjusters.lastInMonth(aimedDayOfWeek));
            case TEENTH:
                LocalDate current = firstDayOfMonth;
                while (!isTenth(current)) {
                    current = next(current, aimedDayOfWeek);
                }
                return current;
            default:

                final List<Function<LocalDate, LocalDate>> necessaryDateTransformations = Collections.nCopies(
                        computeNumberOfShift(meetupSchedule, aimedDayOfWeek),
                        localDate -> next(localDate, aimedDayOfWeek)
                );
                return necessaryDateTransformations
                        .stream()
                        .reduce(firstDayOfMonth, (d, f) -> f.apply(d), (previous, next) -> next);
        }
    }

    private int computeNumberOfShift(MeetupSchedule meetupSchedule, DayOfWeek aimedDayOfWeek) {
        int shift = meetupSchedule.ordinal();
        if (firstDayOfMonth.getDayOfWeek() != aimedDayOfWeek) {
            return shift+1;
        }
        return shift;
    }

    private LocalDate next(LocalDate current, DayOfWeek dayOfWeek) {
        return current.with(TemporalAdjusters.next(dayOfWeek));
    }

    private boolean isTenth(LocalDate localDate) {
        return localDate.getDayOfMonth() > 12 && localDate.getDayOfMonth() < 20;
    }

}
