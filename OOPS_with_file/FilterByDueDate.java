import java.time.LocalDate;

public interface FilterByDueDate extends Filter{
        void filterTaskByDueDate(LocalDate date);
}
