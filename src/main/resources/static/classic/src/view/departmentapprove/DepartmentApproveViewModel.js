Ext.define('Admin.view.departmentapprove.DepartmentApproveViewModel', {
    extend: 'Ext.app.ViewModel',
    alias: 'viewmodel.departmentApproveViewModel',
    requires: [
        'Ext.data.Store',
        'Ext.data.proxy.Memory',
        'Ext.data.field.Integer',
        'Ext.data.field.String',
        'Ext.data.field.Date',
        'Ext.data.field.Boolean',
        'Ext.data.reader.Json'
    ],
    stores: {
    	departmentApproveStore: {type: 'departmentApproveStore'}//调用组件2
    }
});