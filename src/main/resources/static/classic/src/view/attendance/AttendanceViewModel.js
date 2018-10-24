Ext.define('Admin.view.attendance.AttendanceViewModel', {
    extend: 'Ext.app.ViewModel',
    alias: 'viewmodel.attendanceViewModel',

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
		clockDetailLists: {type: 'clockDetailGridStore'},
		lateEarlyLists: {type: 'lateEarlyGridStore'},
		overWorkLists: {type: 'overWorkGridStore'}
    }
});
