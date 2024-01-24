package com.ecrr.fct.serializer.pdx;

import com.ecrr.fct.model.People;
import lombok.*;


/**
 * @PROJECT IntelliJ IDEA
 * @AUTHOR Bikash Mainali
 * @DATE 1/22/24
 */

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class People1{

    private String name;

//    @Override
//    public void toData(PdxWriter writer) {
//        writer.writeString("1", name);
//    }
//
//    @Override
//    public void fromData(PdxReader reader) {
//        reader.readString("1");
//    }
}
