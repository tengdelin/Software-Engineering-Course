<template>
  <div style="padding: 10px">
    <!--    增删改-->
    <div style="margin: 10px 0;">
      <el-button type="primary" @click="add">新增</el-button>
      <el-button type="primary">导入</el-button>
      <el-button type="primary">导出</el-button>
    </div>
    <!--    搜索-->
    <div style="margin:10px 0">
      <el-input v-model="search" placeholder="请输入关键字" style="width: 20%" clearable></el-input>
      <el-button style="margin-left: 8px" @click="load">搜索</el-button>
    </div>
    <!--    表格-->
    <el-table
        :data="tableData"
        border
        stripe
        style="width: 100%">
      <el-table-column
          prop="id"
          label="ID"
          sortable
      >
      </el-table-column>
      <el-table-column
          prop="name"
          label="姓名"
      >
      </el-table-column>
      <el-table-column
          prop="stuId"
          label="学号"
      >
      </el-table-column>
      <el-table-column
          prop="home"
          label="家乡">
      </el-table-column>
      <el-table-column
          prop="age"
          label="年龄">
      </el-table-column>
      <el-table-column
          prop="banji"
          label="班级">
      </el-table-column>
      <el-table-column
          prop="scores"
          label="成绩"
          sortable
      >
      </el-table-column>
      <el-table-column
          label="照片">
        <template #default="scope">
          <el-image
              style="width: 100px; height: 100px"
              :src="scope.row.photo"
              :preview-src-list="[scope.row.photo]">
          </el-image>
        </template>
      </el-table-column>
      <el-table-column label="操作" width="260">
        <template #default="scope">
          <el-button size="mini" type="primary" plain @click="handleEdit(scope.row)">编辑</el-button>
          <el-popconfirm title="确定删除吗？" @confirm="handleDelete(scope.row.id)">
            <template #reference>
              <el-button size="mini" type="danger">删除</el-button>
            </template>
          </el-popconfirm>
        </template>
      </el-table-column>
    </el-table>
    <!--    分页-->
    <div style="margin: 10px">
      <el-pagination
          @size-change="handleSizeChange"
          @current-change="handleCurrentChange"
          :current-page="currentPage"
          :page-sizes="[5, 10, 20, 50]"
          :page-size="pageSize"
          layout="total, sizes, prev, pager, next, jumper"
          :total="total">
      </el-pagination>
    </div>
    <!--新增弹窗-->
    <el-dialog title="提示" v-model="dialogVisible" width="30%">
      <el-form model="form" label-width="120px">
        <el-form-item label="姓名">
          <el-input v-model="form.name" style="width: 80%"></el-input>
        </el-form-item>
        <el-form-item label="学号">
          <el-input v-model="form.stuId" style="width: 80%"></el-input>
        </el-form-item>
        <el-form-item label="家乡">
          <el-input v-model="form.home" style="width: 80%"></el-input>
        </el-form-item>
        <el-form-item label="年龄">
          <el-input v-model="form.age" style="width: 80%"></el-input>
        </el-form-item>
        <el-form-item label="班级">
          <el-input v-model="form.banji" style="width: 80%"></el-input>
        </el-form-item>
        <el-form-item label="成绩">
          <el-input v-model="form.scores" style="width: 80%"></el-input>
        </el-form-item>
        <el-form-item
            label="照片">
          <el-upload  ref="upload" action="http://localhost:9090/files/upload" :on-success="filesUploadSuccess">
            <el-button type="primary">点击上传</el-button>
          </el-upload>
        </el-form-item>

      </el-form>
      <template #footer>
      <span class="dialog-footer">
      <el-button @click="dialogVisible = false">取 消</el-button>
      <el-button type="primary" @click="save">确 定</el-button>
      </span>
      </template>
    </el-dialog>
  </div>
</template>

<script>
import request from "../utils/request";

export default {
  name: 'User',
  components: {},
  data() {
    return {
      loading: true,
      form: {},
      dialogVisible: false,
      bookVis: false,
      search: '',
      currentPage: 1,
      pageSize: 10,
      total: 0,
      tableData: [],
      // filesUploadUrl: "http://" + window.server.filesUploadUrl + ":9090/files/upload",
      bookList: []
    }
  },
  created() {
    this.load()
  },
  methods: {
    filesUploadSuccess(res) {
      this.form.photo = res.data
    },
    add() {
      this.dialogVisible = true
      this.form = {}
      if (this.$refs['upload']) {
        this.$refs['upload'].clearFiles()  // 清除历史文件列表
      }
    },
    save() {
      if (this.form.id) {  // 更新
        request.put("/student", this.form).then(res => {
          if (res.code === '0') {
            this.$message({
              type: "success",
              message: "更新成功"
            })
          } else {
            this.$message({
              type: "error",
              message: res.msg
            })
          }
          this.load() // 刷新表格的数据
          this.dialogVisible = false  // 关闭弹窗
        })
      } else {  // 新增
        request.post("/student", this.form).then(res => {
          if (res.code === '0') {
            this.$message({
              type: "success",
              message: "新增成功"
            })
          } else {
            this.$message({
              type: "error",
              message: res.msg
            })
          }
          this.load() // 刷新表格的数据
          this.dialogVisible = false  // 关闭弹窗
        })
      }
    },
    load() {
      this.loading = true
      request.get("/student", {
        params: {
          pageNum: this.currentPage,
          pageSize: this.pageSize,
          search: this.search
        }
      }).then(res => {
        this.loading = false
        this.tableData = res.data.records
        this.total = res.data.total
      })
    },
    handleSizeChange(val) {
      this.pageSize = val
      this.load()
    },
    handleCurrentChange(val) {
      this.currentPage = val
      this.load()
    },
    handleEdit(row) {
      this.form = JSON.parse(JSON.stringify(row))
      this.dialogVisible = true
      this.$nextTick(() => {
        if (this.$refs['upload']) {
          this.$refs['upload'].clearFiles()  // 清除历史文件列表
        }
      })
    },
    handleDelete(id) {
      request.delete("/student/" + id).then(res => {
        if (res.code === '0') {
          this.$message({
            type: "success",
            message: "删除成功"
          })
        } else {
          this.$message({
            type: "error",
            message: res.msg
          })
        }
        this.load()  // 删除之后重新加载表格的数据
      })
    }
  }
}
</script>
