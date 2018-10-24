Ext.define('Admin.view.attendance.Attendance', {
    extend: 'Ext.container.Container',
    xtype: 'attendance',
    
    controller: 'attendanceViewController',
    viewModel: {type: 'attendanceViewModel'},
    	
    layout: 'fit',
    items: [{xtype:'attendancePanel'}]
});