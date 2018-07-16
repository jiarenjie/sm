package com.demo.ctl;

import com.demo.entity.Result;
import com.demo.entity.User;
import com.demo.enums.ResultEnum;
import com.demo.exceptions.BusinessException;
import com.demo.mapper.UserMapper;
import com.demo.utils.ResultUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @author 刘
 * @date 2018/7/12
 */
@RestController
@Transactional
@RequestMapping("/test")
public class TestCtl  {
    private static Logger LOGGER = LoggerFactory.getLogger(TestCtl.class);
    @Autowired
    Environment env;

    @Autowired(required = false)
    private UserMapper um;


    @RequestMapping("/test1")
    public Result<Object> test1(@RequestParam(value = "pageNum",defaultValue ="0" ) Integer pageNum, @RequestParam(value ="pageSize",defaultValue ="0") Integer pageSize) {

        PageHelper.startPage(pageNum, pageSize);
        List<User> users = um.selectAll();
        PageInfo<User> pageInfo = new PageInfo<>(users);
        return ResultUtil.success(pageInfo);

    }

    @RequestMapping("/test2")
    public Result<Object> test2(@RequestParam("x") int x, @RequestParam("y") int y) {
        int i;
        try {
            i = exceptionTest(x,y);
        } catch (Exception e) {
            throw new BusinessException(ResultEnum.ERROR);
        }
        return ResultUtil.success(i);
    }
    @RequestMapping(value = "/test3",method = RequestMethod.POST)
    public Result<Object> test3(@RequestBody User user) {
        um.insert(user);
        return ResultUtil.success(user);

    }
    @RequestMapping(value = "/test4")
    public Result<Object> test4(@RequestParam("id") Integer id) {
        User user = um.selectUserAndRoleByPK(id);
        return ResultUtil.success(user);
    }

    private int exceptionTest(int x, int y) {
        int i = x / y;
        return i;
    }
}
