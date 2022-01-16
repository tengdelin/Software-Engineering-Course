package com.example.demo.controller;


import cn.hutool.core.util.EscapeUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.common.Result;
import com.example.demo.entity.CResult;
import com.example.demo.entity.Calc;

import com.example.demo.mapper.CalcMapper;
import com.example.demo.mapper.ResultMapper;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/1-sw")
public class CalcController {
    @Resource
    CalcMapper calcMapper;
    ResultMapper resultMapper;

    @PostMapping
    public Result<?> save_and_calc(@RequestBody Calc calc) {
        if (calc.getPlane_type() == null) {
            return Result.error("1", "航班类型不能为空");
        }
        //开始计算价钱
        int cres = calcRes(calc);
        if (cres == -1) {
            return Result.error("1", "托运行李不符合规范，请重新输入");
        }

        CResult res = new CResult();
        res.setResult(cres);
        calc.setRes(cres);
        calcMapper.insert(calc);
        return Result.success(res);
    }

    /***
     * 计算函数
     * @param calc
     * @return 计算行李价钱结果
     */
    public  int calcRes(Calc calc) {
        String plane_type = calc.getPlane_type();
        String person_type = calc.getPerson_type();
        String vip_type = calc.getVip_type();
        String seat_type = calc.getSeat_type();
        String region = calc.getRegion();
        Integer num = calc.getNum();
        Integer length1 = calc.getLength1();
        Integer weight1 = calc.getWeight1();
        Integer length2 = calc.getLength2();
        Integer weight2 = calc.getWeight2();
        Integer price = calc.getPrice();
        int error = finderror(length1, length2, weight1, weight2, price, num);
        if (error == -1) {
            return error;
        }
        //航班类型
        if (plane_type.equals("国内航班")) {
            return incountry(length1, weight1, person_type, seat_type, price, vip_type);
        } else if (plane_type.equals("国际航班")) {
            return outcountry(length1, length2, weight1, weight2, seat_type, region, num);
        } else {
            return -1;//其他航班，并没有其他航班
        }
    }

    /***
     * 国内航班
     * @param length1
     * @param weight1
     * @param person_type
     * @param seat_type
     * @param price
     * @param vip_type
     * @return
     */
    public int incountry(Integer length1, Integer weight1, String person_type, String seat_type, Integer price, String vip_type) {
        int res = 0;
        //排除掉尺寸
        if (length1 > 158 && length1 <= 203) {
            res += 100;//自己设定的100元尺寸超了的钱
        } else if (length1 > 203) {//不能大于203
            return -1;
        }
        //旅客类型
        switch (person_type) {
            case "p-1":
            case "p-2": //成人和儿童
                //舱位类型
                switch (seat_type) {
                    case "s-2"://头等舱40
                        //VIP类型
                        switch (vip_type) {
                            case "v-0":
                                if (weight1 > 40) {
                                    res += (weight1 - 40) * price * 0.015;
                                }
                                break;
                            case "v-1":
                            case "v-2"://凤凰知音终身白金卡、白金卡,额外30
                                if (weight1 > 70) {
                                    res += (weight1 - 70) * price * 0.015;
                                }
                                break;
                            case "v-3":
                            case "v-4":
                            case "v-5"://凤凰知音金卡、银卡、星空联盟金卡，额外20
                                if (weight1 > 60) {
                                    res += (weight1 - 60) * price * 0.015;
                                }
                                break;
                        }
                        break;
                    case "s-3"://商务舱30
                        //VIP类型
                        switch (vip_type) {
                            case "v-0":
                                if (weight1 > 30) {
                                    res += (weight1 - 30) * price * 0.015;
                                }
                                break;
                            case "v-1":
                            case "v-2"://凤凰知音终身白金卡、白金卡,额外30
                                if (weight1 > 60) {
                                    res += (weight1 - 60) * price * 0.015;
                                }
                                break;
                            case "v-3":
                            case "v-4":
                            case "v-5"://凤凰知音金卡、银卡、星空联盟金卡，额外20
                                if (weight1 > 50) {
                                    res += (weight1 - 50) * price * 0.015;
                                }
                                break;
                        }
                        break;
                    case "s-6"://经济舱20
                        //VIP类型
                        switch (vip_type) {
                            case "v-0":
                                if (weight1 > 20) {
                                    res += (weight1 - 20) * price * 0.015;
                                }
                                break;
                            case "v-1":
                            case "v-2"://凤凰知音终身白金卡、白金卡,额外30
                                if (weight1 > 50) {
                                    res += (weight1 - 50) * price * 0.015;
                                }
                                break;
                            case "v-3":
                            case "v-4":
                            case "v-5"://凤凰知音金卡、银卡、星空联盟金卡，额外20
                                if (weight1 > 40) {
                                    res += (weight1 - 40) * price * 0.015;
                                }
                                break;
                        }
                        break;
                }
                break;
            case "p-3"://婴儿
                //随便哪个舱都为10
                //VIP类型
                switch (vip_type) {
                    case "v-0":
                        if (weight1 > 10) {
                            res += (weight1 - 10) * price * 0.015;
                        }
                        break;
                    case "v-1":
                    case "v-2"://凤凰知音终身白金卡、白金卡,额外30
                        if (weight1 > 40) {
                            res += (weight1 - 40) * price * 0.015;
                        }
                        break;
                    case "v-3":
                    case "v-4":
                    case "v-5"://凤凰知音金卡、银卡、星空联盟金卡，额外20
                        if (weight1 > 30) {
                            res += (weight1 - 30) * price * 0.015;
                        }
                        break;
                }
                //可多加一个婴儿车
                break;
        }
        return res;
    }

    /***
     * 国际航班
     * @param length1
     * @param length2
     * @param weight1
     * @param weight2
     * @param seat_type
     * @param region
     * @param num
     * @return
     */
    public int outcountry(Integer length1, Integer length2, Integer weight1, Integer weight2, String
            seat_type, String region, Integer num) {
        int res = 0;
        //排除掉尺寸
        if (length1 > 203 || length2 > 203 || weight1 > 32 || weight2 > 32) {
            return -1;
        }
        //旅客类型
        int addnum = 0;
        switch (seat_type) {
            case "s-2":
            case "s-3"://头等舱、公务舱：2，32
                switch (region) {
                    case "r-1-1":
                        //第一件
                        if (weight1 <= 32 && length1 > 158) {
                            res += 980;
                        }
                        //第二件
                        if (weight2 <= 32 && length2 > 158) {
                            res += 980;
                        }
                        if (num > 2) {
                            //大于2件行李
                            addnum = (num - 2);
                            switch (addnum) {
                                case 1:
                                    res += 1400;
                                    break;
                                case 2:
                                    res += 3400;
                                    break;
                                default:
                                    res = res + 3400 + (addnum - 2) * 3000;
                                    break;
                            }
                        }
                        break;
                    case "r-2-1":
                    case "r-2-2":
                    case "r-2-3":
                        //第一件
                        if (weight1 <= 32 && length1 > 158) {
                            res += 690;
                        }
                        //第二件
                        if (weight2 <= 32 && length2 > 158) {
                            res += 690;
                        }
                        if (num > 2) {
                            //大于2件行李
                            addnum = (num - 2);
                            switch (addnum) {
                                case 1:
                                    res += 1100;
                                    break;
                                case 2:
                                    res += 2200;
                                    break;
                                default:
                                    res = res + 2200 + (addnum - 2) * 1590;
                                    break;
                            }
                        }
                        break;
                    case "r-3-1":
                        //第一件
                        if (weight1 <= 32 && length1 > 158) {
                            res += 520;
                        }
                        //第二件
                        if (weight2 <= 32 && length2 > 158) {
                            res += 520;
                        }
                        if (num > 2) {
                            //大于2件行李
                            addnum = (num - 2);
                            switch (addnum) {
                                case 1:
                                    res += 1170;
                                    break;
                                case 2:
                                    res += 2340;
                                    break;
                                default:
                                    res = res + 2340 + (addnum - 2) * 1590;
                                    break;
                            }
                        }
                        break;
                    case "r-4-1":
                        //第一件
                        if (weight1 <= 32 && length1 > 158) {
                            res += 1040;
                        }
                        //第二件
                        if (weight2 <= 32 && length2 > 158) {
                            res += 1040;
                        }
                        if (num > 2) {
                            //大于2件行李
                            addnum = (num - 2);
                            switch (addnum) {
                                case 1:
                                    res += 1380;
                                    break;
                                case 2:
                                    res += 2760;
                                    break;
                                default:
                                    res = res + 2760 + (addnum - 2) * 1590;
                                    break;
                            }
                        }
                        break;
                    case "r-5-1":
                    case "r-5-2":
                    case "r-5-3":
                        //第一件
                        if (weight1 <= 32 && length1 > 158) {
                            res += 520;
                        }
                        //第二件
                        if (weight2 <= 32 && length2 > 158) {
                            res += 520;
                        }
                        if (num > 2) {
                            //大于2件行李
                            addnum = (num - 2);
                            switch (addnum) {
                                case 1:
                                    res += 830;
                                    break;
                                case 2:
                                    res += 1930;
                                    break;
                                default:
                                    res = res + 1930 + (addnum - 2) * 1590;
                                    break;
                            }
                        }
                        break;
                }
                break;
            case "s-4":
            case "s-5"://悦享经济舱、超级经济舱：2，23
                switch (region) {
                    case "r-1-1":
                        //第一件
                        if (weight1 <= 23 && length1 > 158) {//不超重但超尺寸
                            res += 980;
                        } else if (weight1 <= 28 && weight1 > 23 && length1 < 158) {//超重1但不超尺寸
                            res += 380;
                        } else if (weight1 <= 32 && weight1 > 28 && length1 < 158) {//超重2但不超尺寸
                            res += 980;
                        } else if (weight1 <= 32 && weight1 > 23 && length1 > 158) {//超重，超尺寸
                            res += 1400;
                        }
                        //第二件
                        if (weight2 <= 23 && length2 > 158) {//不超重但超尺寸
                            res += 980;
                        } else if (weight2 <= 28 && weight2 > 23 && length2 < 158) {//超重1但不超尺寸
                            res += 380;
                        } else if (weight2 <= 32 && weight2 > 28 && length2 < 158) {//超重2但不超尺寸
                            res += 980;
                        } else if (weight2 <= 32 && weight2 > 23 && length2 > 158) {//超重，超尺寸
                            res += 1400;
                        }
                        if (num > 2) {
                            //大于2件行李
                            addnum = (num - 2);
                            switch (addnum) {
                                case 1:
                                    res += 1400;
                                    break;
                                case 2:
                                    res += 3400;
                                    break;
                                default:
                                    res = res + 3400 + (addnum - 2) * 3000;
                                    break;
                            }
                        }
                        break;
                    case "r-2-1":
                    case "r-2-2":
                    case "r-2-3":
                        //第一件
                        if (weight1 <= 23 && length1 > 158) {//不超重但超尺寸
                            res += 690;
                        } else if (weight1 <= 28 && weight1 > 23 && length1 < 158) {//超重1但不超尺寸
                            res += 280;
                        } else if (weight1 <= 32 && weight1 > 28 && length1 < 158) {//超重2但不超尺寸
                            res += 690;
                        } else if (weight1 <= 32 && weight1 > 23 && length1 > 158) {//超重，超尺寸
                            res += 1100;
                        }
                        //第二件
                        if (weight2 <= 23 && length2 > 158) {//不超重但超尺寸
                            res += 690;
                        } else if (weight2 <= 28 && weight2 > 23 && length2 < 158) {//超重1但不超尺寸
                            res += 280;
                        } else if (weight2 <= 32 && weight2 > 28 && length2 < 158) {//超重2但不超尺寸
                            res += 690;
                        } else if (weight2 <= 32 && weight2 > 23 && length2 > 158) {//超重，超尺寸
                            res += 1100;
                        }
                        if (num > 2) {
                            //大于2件行李
                            addnum = (num - 2);
                            switch (addnum) {
                                case 1:
                                    res += 1100;
                                    break;
                                case 2:
                                    res += 2200;
                                    break;
                                default:
                                    res = res + 2200 + (addnum - 2) * 1590;
                                    break;
                            }
                        }
                        break;
                    case "r-3-1":
                        //第一件
                        if (weight1 <= 23 && length1 > 158) {//不超重但超尺寸
                            res += 520;
                        } else if (weight1 <= 28 && weight1 > 23 && length1 < 158) {//超重1但不超尺寸
                            res += 520;
                        } else if (weight1 <= 32 && weight1 > 28 && length1 < 158) {//超重2但不超尺寸
                            res += 520;
                        } else if (weight1 <= 32 && weight1 > 23 && length1 > 158) {//超重，超尺寸
                            res += 520;
                        }
                        //第二件
                        if (weight2 <= 23 && length2 > 158) {//不超重但超尺寸
                            res += 520;
                        } else if (weight2 <= 28 && weight2 > 23 && length2 < 158) {//超重1但不超尺寸
                            res += 520;
                        } else if (weight2 <= 32 && weight2 > 28 && length2 < 158) {//超重2但不超尺寸
                            res += 520;
                        } else if (weight2 <= 32 && weight2 > 23 && length2 > 158) {//超重，超尺寸
                            res += 520;
                        }
                        if (num > 2) {
                            //大于2件行李
                            addnum = (num - 2);
                            switch (addnum) {
                                case 1:
                                    res += 1170;
                                    break;
                                case 2:
                                    res += 2340;
                                    break;
                                default:
                                    res = res + 2340 + (addnum - 2) * 1590;
                                    break;
                            }
                        }
                        break;
                    case "r-4-1":
                        //第一件
                        if (weight1 <= 23 && length1 > 158) {//不超重但超尺寸
                            res += 1040;
                        } else if (weight1 <= 28 && weight1 > 23 && length1 < 158) {//超重1但不超尺寸
                            res += 690;
                        } else if (weight1 <= 32 && weight1 > 28 && length1 < 158) {//超重2但不超尺寸
                            res += 1040;
                        } else if (weight1 <= 32 && weight1 > 23 && length1 > 158) {//超重，超尺寸
                            res += 2050;
                        }
                        //第二件
                        if (weight2 <= 23 && length2 > 158) {//不超重但超尺寸
                            res += 1040;
                        } else if (weight2 <= 28 && weight2 > 23 && length2 < 158) {//超重1但不超尺寸
                            res += 690;
                        } else if (weight2 <= 32 && weight2 > 28 && length2 < 158) {//超重2但不超尺寸
                            res += 1040;
                        } else if (weight2 <= 32 && weight2 > 23 && length2 > 158) {//超重，超尺寸
                            res += 2050;
                        }
                        if (num > 2) {
                            //大于2件行李
                            addnum = (num - 2);
                            switch (addnum) {
                                case 1:
                                    res += 1380;
                                    break;
                                case 2:
                                    res += 2760;
                                    break;
                                default:
                                    res = res + 2760 + (addnum - 2) * 1590;
                                    break;
                            }
                        }
                        break;
                    case "r-5-1":
                    case "r-5-2":
                    case "r-5-3":
                        //第一件
                        if (weight1 <= 23 && length1 > 158) {//不超重但超尺寸
                            res += 520;
                        } else if (weight1 <= 28 && weight1 > 23 && length1 < 158) {//超重1但不超尺寸
                            res += 210;
                        } else if (weight1 <= 32 && weight1 > 28 && length1 < 158) {//超重2但不超尺寸
                            res += 520;
                        } else if (weight1 <= 32 && weight1 > 23 && length1 > 158) {//超重，超尺寸
                            res += 830;
                        }
                        //第二件
                        if (weight2 <= 23 && length2 > 158) {//不超重但超尺寸
                            res += 520;
                        } else if (weight2 <= 28 && weight2 > 23 && length2 < 158) {//超重1但不超尺寸
                            res += 210;
                        } else if (weight2 <= 32 && weight2 > 28 && length2 < 158) {//超重2但不超尺寸
                            res += 520;
                        } else if (weight2 <= 32 && weight2 > 23 && length2 > 158) {//超重，超尺寸
                            res += 830;
                        }
                        if (num > 2) {
                            //大于2件行李
                            addnum = (num - 2);
                            switch (addnum) {
                                case 1:
                                    res += 830;
                                    break;
                                case 2:
                                    res += 1930;
                                    break;
                                default:
                                    res = res + 1930 + (addnum - 2) * 1590;
                                    break;
                            }
                        }
                        break;
                }
                break;
            case "s-6"://经济舱
                //2件23,设定区域1，2为运行2件行李的地区
                //1件23，设定区域3，4，5为运行1件行李的地区
                switch (region) {
                    case "r-1-1":
                        //第一件
                        if (weight1 <= 23 && length1 > 158) {//不超重但超尺寸
                            res += 980;
                        } else if (weight1 <= 28 && weight1 > 23 && length1 < 158) {//超重1但不超尺寸
                            res += 380;
                        } else if (weight1 <= 32 && weight1 > 28 && length1 < 158) {//超重2但不超尺寸
                            res += 980;
                        } else if (weight1 <= 32 && weight1 > 23 && length1 > 158) {//超重，超尺寸
                            res += 1400;
                        }
                        //第二件
                        if (weight2 <= 23 && length2 > 158) {//不超重但超尺寸
                            res += 980;
                        } else if (weight2 <= 28 && weight2 > 23 && length2 < 158) {//超重1但不超尺寸
                            res += 380;
                        } else if (weight2 <= 32 && weight2 > 28 && length2 < 158) {//超重2但不超尺寸
                            res += 980;
                        } else if (weight2 <= 32 && weight2 > 23 && length2 > 158) {//超重，超尺寸
                            res += 1400;
                        }
                        if (num > 2) {
                            //大于2件行李
                            addnum = (num - 2);
                            switch (addnum) {
                                case 1:
                                    res += 1400;
                                    break;
                                case 2:
                                    res += 3400;
                                    break;
                                default:
                                    res = res + 3400 + (addnum - 2) * 3000;
                                    break;
                            }
                        }
                        break;
                    case "r-2-1":
                    case "r-2-2":
                    case "r-2-3":
                        //第一件
                        if (weight1 <= 23 && length1 > 158) {//不超重但超尺寸
                            res += 690;
                        } else if (weight1 <= 28 && weight1 > 23 && length1 < 158) {//超重1但不超尺寸
                            res += 280;
                        } else if (weight1 <= 32 && weight1 > 28 && length1 < 158) {//超重2但不超尺寸
                            res += 690;
                        } else if (weight1 <= 32 && weight1 > 23 && length1 > 158) {//超重，超尺寸
                            res += 1100;
                        }
                        //第二件
                        if (weight2 <= 23 && length2 > 158) {//不超重但超尺寸
                            res += 690;
                        } else if (weight2 <= 28 && weight2 > 23 && length2 < 158) {//超重1但不超尺寸
                            res += 280;
                        } else if (weight2 <= 32 && weight2 > 28 && length2 < 158) {//超重2但不超尺寸
                            res += 690;
                        } else if (weight2 <= 32 && weight2 > 23 && length2 > 158) {//超重，超尺寸
                            res += 1100;
                        }
                        if (num > 2) {
                            //大于2件行李
                            addnum = (num - 2);
                            switch (addnum) {
                                case 1:
                                    res += 1100;
                                    break;
                                case 2:
                                    res += 2200;
                                    break;
                                default:
                                    res = res + 2200 + (addnum - 2) * 1590;
                                    break;
                            }
                        }
                        break;

                    case "r-3-1":
                        //第一件
                        if (weight1 <= 23 && length1 > 158) {//不超重但超尺寸
                            res += 520;
                        } else if (weight1 <= 28 && weight1 > 23 && length1 < 158) {//超重1但不超尺寸
                            res += 520;
                        } else if (weight1 <= 32 && weight1 > 28 && length1 < 158) {//超重2但不超尺寸
                            res += 520;
                        } else if (weight1 <= 32 && weight1 > 23 && length1 > 158) {//超重，超尺寸
                            res += 520;
                        }
                        if (num > 1) {
                            //大于1件行李
                            addnum = (num - 1);
                            switch (addnum) {
                                case 1:
                                    res += 1170;
                                    break;
                                case 2:
                                    res += 2340;
                                    break;
                                default:
                                    res = res + 2340 + (addnum - 2) * 1590;
                                    break;
                            }
                        }
                        break;
                    case "r-4-1":
                        //第一件
                        if (weight1 <= 23 && length1 > 158) {//不超重但超尺寸
                            res += 1040;
                        } else if (weight1 <= 28 && weight1 > 23 && length1 < 158) {//超重1但不超尺寸
                            res += 690;
                        } else if (weight1 <= 32 && weight1 > 28 && length1 < 158) {//超重2但不超尺寸
                            res += 1040;
                        } else if (weight1 <= 32 && weight1 > 23 && length1 > 158) {//超重，超尺寸
                            res += 2050;
                        }
                        if (num > 1) {
                            //大于2件行李
                            addnum = (num - 1);
                            switch (addnum) {
                                case 1:
                                    res += 1380;
                                    break;
                                case 2:
                                    res += 2760;
                                    break;
                                default:
                                    res = res + 2760 + (addnum - 2) * 1590;
                                    break;
                            }
                        }
                        break;
                    case "r-5-1":
                    case "r-5-2":
                    case "r-5-3":
                        //第一件
                        if (weight1 <= 23 && length1 > 158) {//不超重但超尺寸
                            res += 520;
                        } else if (weight1 <= 28 && weight1 > 23 && length1 < 158) {//超重1但不超尺寸
                            res += 210;
                        } else if (weight1 <= 32 && weight1 > 28 && length1 < 158) {//超重2但不超尺寸
                            res += 520;
                        } else if (weight1 <= 32 && weight1 > 23 && length1 > 158) {//超重，超尺寸
                            res += 830;
                        }
                        if (num > 1) {
                            //大于2件行李
                            addnum = (num - 1);
                            switch (addnum) {
                                case 1:
                                    res += 830;
                                    break;
                                case 2:
                                    res += 1930;
                                    break;
                                default:
                                    res = res + 1930 + (addnum - 2) * 1590;
                                    break;
                            }
                        }
                        break;
                }
                break;
        }
        return res;
    }

    /***
     * 进行初始错误排除
     * @param length1
     * @param length2
     * @param weight1
     * @param weight2
     * @param price
     * @param num
     * @return
     */
    public int finderror(int length1, int length2, int weight1, int weight2, int price, int num) {
        //排除负的错误数据
        if (length1 < 0 || weight1 < 0 || length2 < 0 || weight2 < 0 || price < 0 || num <= 0 || num > 7) {
            return -1;
        }
        return 0;
    }

}