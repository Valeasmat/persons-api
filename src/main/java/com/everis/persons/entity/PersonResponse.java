package com.everis.persons.entity;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@ApiModel("Person response")
public class PersonResponse {
    @ApiModelProperty(example = "1",position = 1)
    private Integer id;
    @ApiModelProperty(example = "10000000",position = 2)
    private String document;
    @ApiModelProperty(example = "true",position = 3)
    private Boolean fingerprint;
    @ApiModelProperty(example = "false",position = 4)
    private Boolean blacklist;
}
