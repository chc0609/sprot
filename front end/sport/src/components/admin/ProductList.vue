<template>
  <div>
    <!-- 面包屑导航开始 -->
    <el-breadcrumb separator-class="el-icon-arrow-right">
      <el-breadcrumb-item :to="{ path: '/home' }">返回首页</el-breadcrumb-item>
      <!-- <el-breadcrumb-item>权限管理</el-breadcrumb-item> -->
      <!-- <el-breadcrumb-item>用户列表</el-breadcrumb-item> -->
    </el-breadcrumb>
    <!-- 面包屑导航开始 -->

    <!-- 产品列表主体部分开始 -->
    <el-card>
      <el-row :gutter="25">
        <!-- 间隙 -->
        <!-- 搜索区域开始 -->
        <el-col :span="10">
          <!-- 列宽 -->
          <el-input placeholder="请输入搜索内容" v-model="queryProInfo.queryName" clearable @clear="getProductList">
            <el-button slot="append" icon="el-icon-search" @click="getProductList"></el-button>
          </el-input>
        </el-col>

        <el-col :span="4">
          <!-- 搜索按钮 -->
          <el-button type="primary" @click="addDialogVisible=true">添加产品</el-button>
        </el-col>
        <!-- 搜索区域结束 -->
      </el-row>

      <!-- 产品列表表格开始  border:边框 ，stripe：隔行变色-->
      <el-table :data="productList" border stripe>
        <el-table-column type="index">
          <!-- 索引列 -->
        </el-table-column>
        <el-table-column label="产品名称" prop="prodName">
          <!--  -->
        </el-table-column>
        <el-table-column label="车型" prop="autoType">
          <!--  -->
        </el-table-column>
        <el-table-column label="零件类型" prop="oem">
          <!--  -->
        </el-table-column>
        <el-table-column label="操作用户" prop="updateUser" width="90%">
          <!--  -->
        </el-table-column>
        <el-table-column label="上架时间" prop="updateTime" >
          <!--  -->
        </el-table-column>
        <el-table-column label="产品图片" prop="imagePath" width="80%">
          <!-- 作用域插槽 -->
          <template slot-scope="scope">
            <!-- {{scope.row}} 每一行封存的数据 -->
            <el-switch v-model="scope.row.state" @change="editProduct(scope.row)"></el-switch>
          </template>

        </el-table-column>
        <el-table-column label="操作">
          <template slot-scope="scope">
            <!-- 修改 -->
            <el-button type="primary" icon="el-icon-edit" size="mini" @click="showEditDialog(scope.row.id)"></el-button>
            <!-- 删除   -->
            <el-button type="danger" icon="el-icon-delete" size="mini" @click="deleteProduct(scope.row.id)"></el-button>
            <!-- 权限 -->
            <el-tooltip effect="dark" content="上传图片" placement="top-start" :enterable="false">
              <!-- 文字提示 enterable隐藏-->
              <el-button type="warning" icon="el-icon-setting" size="mini"></el-button>
            </el-tooltip>
          </template>
        </el-table-column>
      </el-table>
      <!-- 用户列表表格结束 -->

      <!-- 分页组件开始 -->
      <!-- size-change:每页变化最大数 ， current-change：当前页面变化数 -->
      <div>
        <el-pagination @size-change="handleSizeChange" @current-change="handleCurrentChange" :current-page="queryProInfo.pageNum" :page-sizes="[1, 2, 5, 100]" :page-size="queryProInfo.pageSize"
          layout="total, sizes, prev, pager, next, jumper" :total="total">
        </el-pagination>
      </div>
      <!-- 分页组件结束 -->
    </el-card>
    <!-- 用户列表主体部分结束 -->

    <!-- 添加用户区域开始 -->
    <el-dialog title="添加产品" :visible.sync="addDialogVisible" width="50%" @close="addDialogClosed">
      <el-form :model="addForm" :rules="addFormRules" ref="addFormRef" label-width="80px">
        <!-- 产品名称 -->
        <el-form-item label="产品名称" prop="prodName">
          <el-input v-model="addForm.prodName"></el-input>
        </el-form-item>
        <!-- 车型 -->
        <el-form-item label="车型" prop="autoType">
          <el-input v-model="addForm.autoType"></el-input>
        </el-form-item>
        <!-- 零件类型 -->
        <el-form-item label="零件类型" prop="oem">
          <el-input v-model="addForm.oem"></el-input>
        </el-form-item>
      </el-form>
      <!-- 内容底部区域 -->
      <span slot="footer" class="dialog-footer">
        <el-button @click="addDialogVisible=false">取 消</el-button>
        <el-button type="primary" @click="addProduct">确 定</el-button>
      </span>

    </el-dialog>
    <!-- 添加产品区域结束 -->

    <!-- 修改产品开始 -->
    <el-dialog title="修改产品信息" :visible.sync="editDialogVisible" width="50%" @close="editDialogClosed">
      <el-form :model="editForm" :rules="editFormRules" ref="editFormRef" label-width="90px">
        <!-- 产品名称 -->
        <el-form-item label="产品名称" prop="prodName">
          <el-input v-model="editForm.prodName"></el-input>
        </el-form-item>
        <!-- 车型 -->
        <el-form-item label="车型" prop="autoType">
          <el-input v-model="editForm.autoType"></el-input>
        </el-form-item>
        <!-- 零件类型 -->
        <el-form-item label="零件类型" prop="email">
          <el-input v-model="editForm.oem"></el-input>
        </el-form-item>
      </el-form>
      <!-- 内容底部区域 -->
      <span slot="footer" class="dialog-footer">
        <el-button @click="editDialogVisible=false">取 消</el-button>
        <el-button type="primary" @click="editProduct">确 定</el-button>
      </span>

    </el-dialog>
    <!-- 修改用户结束 -->
  </div>
</template>

<script>

export default {
  created() {
    //创建产品列表菜单时调用
    this.getProductList();
  },
  data() {
    return {
      //向后端发送请求的查询信息实体
      queryProInfo: {
        queryName: '',  //查询的产品项
        pageNum: 1,   //当前页
        pageSize: 5,  //每页的条数
      },
      productList: [], //产品列表
      total: 0, //初始总条数为0  
      addDialogVisible: false,//对话框显示隐藏状态
      //添加表单信息
      addForm: {
        prodName: '',
        autoType: '',
        oem: '',
        updateUser: '',
      },
      //修改产品的信息
      editForm: {
        prodName: '',
        autoType: '',
        oem: '',
      },
      editDialogVisible: false, //显示和隐藏修改用户栏
      //添加产品表单验证
      addFormRules: {
        prodName: [
          { required: true, message: '请输入产品名称', trigger: 'blur' },
          { min: 0, max: 255, message: '长度小于255个字符', trigger: 'blur' }
        ],
        autoType: [
          { required: true, message: '请输入车型', trigger: 'blur' },
          { min: 0, max: 500, message: '长度小于255个字符', trigger: 'blur' }
        ],
        oem: [
          { required: true, message: '请输入零件号', trigger: 'blur' },
          { min: 0, max: 500, message: '长度小于255个字符', trigger: 'blur' }
        ],
      },
      //修改用户表单验证
      editFormRules: {
        prodName: [
          { required: true, message: '请输入产品名称', trigger: 'blur' },
          { min: 0, max: 255, message: '长度小于255个字符', trigger: 'blur' }
        ],
        autoType: [
          { required: true, message: '请输入车型', trigger: 'blur' },
          { min: 0, max: 500, message: '长度小于255个字符', trigger: 'blur' }
        ],
        oem: [
          { required: true, message: '请输入零件号', trigger: 'blur' },
          { min: 0, max: 500, message: '长度小于255个字符', trigger: 'blur' }
        ],
      },
    }
  },
  methods: {
    //获取所有产品
    async getProductList() {
      //访问后端allUser地址
      const { data: res } = await this.$http.get("allProduct", { params: this.queryProInfo });
      // console.log(res);
      this.productList = res.list;  //产品列表数据
      this.total = res.count; //总产品数
    },
    //获取分页最大数刷新数据的方法
    handleSizeChange(newSize) {
      this.queryProInfo.pageSize = newSize; //把最新传入的查询条数赋值给pageSize
      this.getProductList(); //重新查询数据
    },
    // 上下页的触发事件
    handleCurrentChange(newPage) {
      this.queryProInfo.pageNum = newPage; //把最新传入的当前页数赋值给pageNum
      this.getProductList(); //重新查询数据
    },
    //修改产品信息
    async editProduct(product) {
      const user = JSON.parse(window.sessionStorage.getItem('user'));
      product.updateUser = user.username;
      const { data: res } = await this.$http.post(`editProduct?product=${product}`); //提交参数到后台
      if (res != "success") {
        product.id = !product.id;
        return this.$message.error("操作失败！");
      }
      this.$message.success("操作成功！");
    },
    //监听添加用户的事件，监听是否关闭
    addDialogClosed() {
      this.$refs.addFormRef.resetFields(); //关闭窗口重置信息
    },
    //添加产品的事件
    addProduct() {
      this.$refs.addFormRef.validate(async valid => {
        //console.log(valid); //里面是true-false
        console.log(window.sessionStorage.getItem('user'));
        const user = JSON.parse(window.sessionStorage.getItem('user'));
        if (!valid) {
          return;
        }
        this.addForm.updateUser=user.username;
        const { data: res } = await this.$http.post("addProduct", this.addForm); //提交表单的信息到后台
        if (res != "success") {
          return this.$message.error("操作失败！");
        }
        this.$message.success("操作成功!");
        this.addDialogVisible = false;
        this.getProductList();
      });
    },
    //根据id删除用户
    async deleteProduct(id) {
      const confirmResult = await this.$confirm('此操作将永久删除产品，是否继续?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).catch(err => err)
      if (confirmResult != 'confirm') { //判断是否取消删除
        return this.$message.info("已取消删除");
      }
      const { data: res } = await this.$http.post("deleteUser?id=" + id);
      if (res != "success") {
        return this.$message.error("删除失败！");
      }
      this.$message.success("删除成功!");
      this.getProductList();
    },
    // //显示或者隐藏编辑输入框
    async showEditDialog(id) {
      const { data: res } = await this.$http.get("getProductById?id=" + id);  //访问后台查询出用户
      console.log(res);
      this.editForm = res; //查询出的用户信息赋值给editForm
      this.editDialogVisible = true; //开启编辑输入框
    },
    //关闭编辑窗口事件
    editDialogClosed() {
      // console.log("哈哈");
      this.$refs.editFormRef.resetFields(); //关闭窗口重置信息
    },

    //确认修改
    editProductInfo() { //表单验证
      this.$refs.editFormRef.validate(async valid => {
        if (!valid) {//验证失败，返回
          return;
        }
        //验证成功发起请求
        const { data: res } = await this.$http.post("editUser", this.editForm); //提交表单的数据到后台
        if (res != "success") {
          return this.$message.error("操作失败!");
        }
        this.$message.success("操作成功!");
        //操作完成隐藏修改的输入框
        this.editDialogVisible = false;
        this.getProductList(); //重新查询数据

      })
    },


  },

}
</script>

<style lang="less" scoped>
.el-breadcrumb {
  margin-bottom: 15px;
  font-size: 17px;
}
</style>