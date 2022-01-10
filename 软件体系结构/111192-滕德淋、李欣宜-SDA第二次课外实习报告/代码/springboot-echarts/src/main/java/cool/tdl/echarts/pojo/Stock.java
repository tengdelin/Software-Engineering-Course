package cool.tdl.echarts.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Stock {
    private int id;
    private String time;
    private String shiyinlv;
    private String junjia;
    private String shoupanjia;
}
