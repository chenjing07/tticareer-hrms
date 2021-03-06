Ext.define('Admin.store.attendance.LateEarlyGridStore', {
    extend: 'Ext.data.Store',
    storeId:'lateEarlyGridStore',
    alias: 'store.lateEarlyGridStore',
    model:'Admin.model.attendance.LateEarlyModel',
    proxy: {
        type: 'ajax',
        url: '/attendance/lequery',
        reader:{
            type:'json',
            rootProperty:'data.content',//对应后台返回的结果集名称
            totalProperty: 'data.totalElements'//分页需要知道总记录数
        },
        writer: {
            type: 'json'
        },
        simpleSortMode: true    //简单排序模式
    },
    autoLoad: true,
    autoSync: true,
    remoteSort: true,//全局排序
    pageSize: 20,
    sorters: {
        direction: 'DESC',property: 'id'
    }
});