package sifan.forum.dto;

import lombok.Data;

@Data
public class RegUserDTO {
    private Integer code;
    private String message;


    public static RegUserDTO errorOf(Integer code, String message) {
        RegUserDTO reguserDTO = new RegUserDTO();
        reguserDTO.setCode(code);
        reguserDTO.setMessage(message);
        return reguserDTO;
    }
    public static RegUserDTO okOf(String t) {
        RegUserDTO reguserDTO = new RegUserDTO();
        reguserDTO.setCode(200);
        reguserDTO.setMessage((String) t);
        return reguserDTO;
    }
}
