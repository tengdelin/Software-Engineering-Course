<template>
  <div style="width: 100%;" :style="bg2"> <!--  :style="bg" 加背景图片-->
    <div style="width: 600px; margin: 120px auto">
      <div style="font-size: 30px; text-align: center; padding: 30px 0; color:black">实习一国航行李计算器</div>
      <el-form
          :model="ruleForm"
          :rules="rules"
          ref="ruleForm"
          label-width="200px"
          class="demo-ruleForm"
      >
        <el-form-item label="航班类型" prop="plane_type">
          <el-radio-group v-model="ruleForm.plane_type">
            <!--            国内-->
            <el-radio label="国内航班" @click="btn1Click"></el-radio>
            <!--            国际-->
            <el-radio label="国际航班" @click="btn2Click"></el-radio>
          </el-radio-group>
        </el-form-item>

        <el-form-item label="旅客类型" prop="person_type">
          <el-select v-model="ruleForm.person_type" placeholder="请选择旅客类型">
            <el-option label="成人" value="p-1" @click="notbabyClick"></el-option>
            <el-option label="儿童" value="p-2" @click="notbabyClick"></el-option>
            <el-option label="婴儿" value="p-3" @click="babyClick" v-show="isShow1"></el-option>
          </el-select>
        </el-form-item>

        <el-form-item label="是否有婴儿车" v-show="isbaby">
          <el-radio-group v-model="form.baby">
            <el-radio label="是"></el-radio>
            <el-radio label="否"></el-radio>
          </el-radio-group>
        </el-form-item>

        <el-form-item label="VIP等级" prop="vip_type" v-show="isShow1">
          <el-select v-model="ruleForm.vip_type" placeholder="请选择VIP等级">
            <el-option label="无" value="v-0"></el-option>
            <el-option label="凤凰知音终身白金卡" value="v-1"></el-option>
            <el-option label="凤凰知音白金卡" value="v-2"></el-option>
            <el-option label="凤凰知音金卡" value="v-3"></el-option>
            <el-option label="凤凰知音银卡" value="v-4"></el-option>
            <el-option label="星空联盟金卡" value="v-5"></el-option>
          </el-select>
        </el-form-item>

        <el-form-item label="座舱类型" prop="seat_type">
          <el-select v-model="ruleForm.seat_type" placeholder="请选择座舱类型">
            <!--            <el-option label="豪华头等舱" value="s-1" v-show="isShow2"></el-option>-->
            <el-option label="头等舱" value="s-2"></el-option>
            <el-option label="公务舱" value="s-3"></el-option>
            <el-option label="悦享经济舱" value="s-4" v-show="isShow2"></el-option>
            <el-option label="超级经济舱" value="s-5" v-show="isShow2"></el-option>
            <el-option label="经济舱" value="s-6"></el-option>
          </el-select>
        </el-form-item>

        <el-form-item label="航线区域" prop="region" v-show="isShow2">
          <el-select v-model="ruleForm.region" placeholder="请选择航线区域">
            <el-option label="区域一:美洲(除美国/加拿大外)/加勒比海地区与欧洲/非洲/中东/亚洲/西南太平洋之间的航线" value="r-1-1"></el-option>
            <el-option label="区域二:欧洲/中东与非洲/亚洲/西南太平洋之间航线" value="r-2-1"></el-option>
            <el-option label="区域二:日本与西南太平洋之间航线" value="r-2-2"></el-option>
            <el-option label="区域二:日本/西南太平洋与亚洲(不含日本及西南太平洋)/非洲之间航线" value="r-2-3"></el-option>
            <el-option label="区域三:加拿大与美洲(除美国/加拿大外)/加勒比海地区/欧洲/非洲/中东/亚洲/西南太平洋之间航线" value="r-3-1"></el-option>
            <el-option label="区域四:美国(含夏威夷)与美洲(除美国外)/加勒比海地区/欧洲/非洲/中东/亚洲/西南太平洋之间航线" value="r-4-1"></el-option>
            <el-option label="区域五:非洲与亚洲(除日本外)之间航线;欧洲与中东之间航线" value="r-5-1"></el-option>
            <el-option label="区域五:亚洲(除日本)内航线" value="r-5-2"></el-option>
            <el-option label="区域五:美洲(除美国/加拿大)及加勒比海地区内航线;上述未列明的航线" value="r-5-3"></el-option>
          </el-select>
        </el-form-item>

        <el-form-item label="行李件数" prop="num" v-show="isShow2">
          <el-select v-model="ruleForm.num" placeholder="请选择行李件数">
            <el-option label="1" value="1" @click="boxbeone"></el-option>
            <el-option label="2" value="2" @click="boxbetwo"></el-option>
            <el-option label="3" value="3" @click="boxbetwo"></el-option>
            <el-option label="4" value="4" @click="boxbetwo"></el-option>
            <el-option label="5" value="5" @click="boxbetwo"></el-option>
            <el-option label="6" value="6" @click="boxbetwo"></el-option>
            <el-option label="7" value="7" @click="boxbetwo"></el-option>
          </el-select>
        </el-form-item>

        <el-form-item label="行李1类型">
          <el-select v-model="ruleForm.spec1" placeholder="请选择行李1类型">
            <el-option value="普通行李">普通行李</el-option>
            <el-option value="婴儿车">婴儿车</el-option>
            <el-option value="可免费运输的特殊行李">可免费运输的特殊行李</el-option>
            <el-option value="运动机械器具A">运动机械器具A</el-option>
            <el-option value="运动机械器具B">运动机械器具B</el-option>
            <el-option value="运动机械器具C">运动机械器具C</el-option>
            <el-option value="其他特殊行李A">其他特殊行李A</el-option>
            <el-option value="其他特殊行李B">其他特殊行李B</el-option>
            <el-option value="其他特殊行李C">其他特殊行李C</el-option>
            <el-option value="其他特殊行李D">其他特殊行李D</el-option>
            <el-option value="其他特殊行李E">其他特殊行李E</el-option>
          </el-select>
        </el-form-item>

        <el-form-item label="行李1尺寸" prop="length1">
          <el-input v-model="ruleForm.length1" placeholder="请输入行李1尺寸"></el-input>
        </el-form-item>

        <el-form-item label="行李1重量" prop="weight1">
          <el-input v-model="ruleForm.weight1" placeholder="请输入行李1重量"></el-input>
        </el-form-item>

        <el-form-item label="行李2类型" v-show="show1">
          <el-select v-model="ruleForm.spec2" placeholder="请选择行李2类型">
            <el-option value="普通行李">普通行李</el-option>
            <el-option value="婴儿车">婴儿车</el-option>
            <el-option value="可免费运输的特殊行李">可免费运输的特殊行李</el-option>
            <el-option value="运动机械器具A">运动机械器具A</el-option>
            <el-option value="运动机械器具B">运动机械器具B</el-option>
            <el-option value="运动机械器具C">运动机械器具C</el-option>
            <el-option value="其他特殊行李A">其他特殊行李A</el-option>
            <el-option value="其他特殊行李B">其他特殊行李B</el-option>
            <el-option value="其他特殊行李C">其他特殊行李C</el-option>
            <el-option value="其他特殊行李D">其他特殊行李D</el-option>
            <el-option value="其他特殊行李E">其他特殊行李E</el-option>
          </el-select>
        </el-form-item>


        <el-form-item label="行李2尺寸" prop="length2" v-show="show1">
          <el-input v-model="ruleForm.length2" placeholder="请输入行李2尺寸"></el-input>
        </el-form-item>

        <el-form-item label="行李2重量" prop="weight2" v-show="show1">
          <el-input v-model="ruleForm.weight2" placeholder="请输入行李2重量"></el-input>
        </el-form-item>

        <el-form-item label="机票价格" prop="price" v-show="isShow1">
          <el-input v-model="ruleForm.price" placeholder="请输入机票价格"></el-input>
        </el-form-item>

        <el-form-item>
          <el-button type="primary" @click="submitForm('ruleForm')" id="submit">
            立即计算
          </el-button>
          <el-button @click="resetForm('ruleForm')">重置</el-button>
        </el-form-item>
      </el-form>
    </div>
    <!--新增弹窗-->
    <el-dialog
        title="需要支付费用"
        v-model="dialogVisible"
        width="30%"
    >
      <span v-text="result +'元'"></span>
      <template #footer>
    <span class="dialog-footer">
      <el-button type="primary" @click="dialogVisible = false">确 定</el-button>
    </span>
      </template>
    </el-dialog>
  </div>
</template>
<script>
import request from "../utils/request";

export default {
  name: "1-sw",
  data() {
    return {
      result: 0,
      dialogVisible: false,
      isShow1: false,
      isShow2: false,
      isbaby: false,
      show1: false,
      form: {
        baby: '',
      },
      ruleForm: {
        plane_type: '',
        person_type: '',
        vip_type: '',
        seat_type: '',
        region: '',
        num: 1,
        spec1: '',
        spec2: '',
        length1: '',
        weight1: '',
        length2: '',
        weight2: '',
        price: ''
      },
      rules: {
        plane_type: [
          {required: true, message: '请选择航班类型', trigger: 'blur'},
        ],
        person_type: [
          {required: true, message: '请选择旅客类型', trigger: 'change'},
        ],
        vip_type: [
          {required: true, message: '请选择VIP等级', trigger: 'change'},
        ],
        seat_type: [
          {required: true, message: '请选择舱座类型', trigger: 'change'},
        ],
        region: [
          {required: true, message: '请选择航线区域', trigger: 'change'},
        ],
        num: [
          {required: true, message: '请选择行李数量', trigger: 'change'},
        ],
        length1: [
          {required: true, message: '请输入行李1尺寸', trigger: 'blur'},
          {
            min: 1,
            max: 5,
            message: '长度在 1 到 5 个字符',
            trigger: 'blur',
          }
        ],
        weight1: [
          {required: true, message: '请输入行李1重量', trigger: 'blur'},
          {
            min: 1,
            max: 5,
            message: '长度在 1 到 5 个字符',
            trigger: 'blur',
          }
        ],
        length2: [
          {required: true, message: '请输入行李2尺寸', trigger: 'blur'},
          {
            min: 1,
            max: 5,
            message: '长度在 1 到 5 个字符',
            trigger: 'blur',
          }
        ],
        weight2: [
          {required: true, message: '请输入行李2重量', trigger: 'blur'},
          {
            min: 1,
            max: 5,
            message: '长度在 1 到 5 个字符',
            trigger: 'blur',
          }
        ],
        price: [
          {required: true, message: '请输入机票价格', trigger: 'blur'},
          {
            min: 1,
            max: 5,
            message: '长度在 1 到 5 个字符',
            trigger: 'blur',
          }
        ]
      },
      // 加背景图片
      bg2: {
        backgroundImage: "url(" + require("@/assets/bg2.jpg") + ")",
        backgroundRepeat: "no-repeat",
        backgroundSize: "100% 100%"
      }
    }
  },
  methods: {
    notbabyClick: function () {
      this.isbaby = false
    },
    babyClick: function () {
      this.isbaby = true
    },
    btn1Click: function () {
      this.isShow1 = true
      this.isShow2 = false
      this.show1 = false
    },
    btn2Click: function () {
      this.isShow2 = true
      this.isShow1 = false
      this.ruleForm.region = ''
      this.ruleForm.person_type = ''
    },
    boxbetwo: function () {
      this.show1 = true
    },
    boxbeone: function () {
      this.show1 = false
    },
    submitForm(formName) {
      if (this.ruleForm.plane_type == "国内航班") {
        this.ruleForm.region = "0"
        this.ruleForm.num = 1
        this.ruleForm.length2 = "0"
        this.ruleForm.weight2 = "0"
      } else if (this.ruleForm.plane_type == "国际航班") {
        if(this.ruleForm.num==1){
          this.ruleForm.length2 = "0"
          this.ruleForm.weight2 = "0"
        }
        this.ruleForm.vip_type = "无"
        this.ruleForm.price = "0"
      }
      this.$refs[formName].validate((valid) => {
        if (valid) {
          request.post("/1-sw", this.ruleForm).then(res => {
            if (res.code === '0') {
              this.$message({
                type: "success",
                message: "计算成功"
              })
              this.result = res.data.result
              this.dialogVisible = true  //开启弹窗显示数据
            } else {
              this.$message({
                type: "error",
                message: res.msg
              })
            }
          })
        } else {
          console.log('error submit!!')
          return false
        }
      })
    },
    resetForm(formName) {
      this.$refs[formName].resetFields()
    }
  }
}
</script>