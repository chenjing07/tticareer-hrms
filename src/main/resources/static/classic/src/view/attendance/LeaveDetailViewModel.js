Ext.define('Admin.view.attendance.LeaveDetailViewModel', {
    extend: 'Ext.app.ViewModel',
    alias: 'viewmodel.leaveDetailViewModel',

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
		leaveDetailLists: {type: 'leaveDetailGridStore'},
		leaveDetailCheckLists: {type: 'leaveDetailCheckGridStore'}
    }
});
