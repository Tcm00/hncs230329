//package com.example.hncs.utils;
//
///**
// * @author 小明
// * @date 2023/3/29
// * @description
// */
//
//import com.github.pagehelper.PageHelper;
//import com.ruoyi.common.core.page.PageDomain;
//import com.ruoyi.common.core.page.TableSupport;
//import com.ruoyi.common.utils.sql.SqlUtil;
//
///**
// * 分页工具类
// *
// * @author ruoyi
// */
//public class PageUtils extends PageHelper
//{
//    /**
//     * 设置请求分页数据
//     */
//    public static void startPage()
//    {
//        PageDomain pageDomain = TableSupport.buildPageRequest();
//        Integer pageNum = pageDomain.getPageNum();
//        Integer pageSize = pageDomain.getPageSize();
//        String orderBy = SqlUtil.escapeOrderBySql(pageDomain.getOrderBy());
//        Boolean reasonable = pageDomain.getReasonable();
//        PageHelper.startPage(pageNum, pageSize, orderBy).setReasonable(reasonable);
//    }
//
//    /**
//     * 清理分页的线程变量
//     */
//    public static void clearPage()
//    {
//        PageHelper.clearPage();
//    }
//}
//
