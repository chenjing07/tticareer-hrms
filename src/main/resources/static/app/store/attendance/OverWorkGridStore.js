Ext.define('Admin.store.attendance.OverWorkGridStore', {
    extend: 'Ext.data.Store',
    storeId:'overWorkGridStore',
    alias: 'store.overWorkGridStore',
    model:'Admin.model.attendance.OverWorkModel',
    proxy: {
        type: 'ajax',
        url: '/attendance/owquery',
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