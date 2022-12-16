package com.masai.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReservationDTO {

    @NotNull(message = "Start point cannot be null!")
    @NotBlank(message = "Start point cannot be blank!")
    private String source;

    @NotNull(message = "Destination point cannot be null!")
    @NotBlank(message = "Destination point cannot be blank!")
    private String destination;

    @NotNull
    private Integer noOfSeatsToBook;

    @NotNull
    @JsonFormat(pattern="yyyy-MM-dd")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate journeyDate;

    private BusDTO busDTO;
}
