Ext.define('Admin.view.attendance.LeaveDetail', {
    extend: 'Ext.container.Container',
    xtype: 'leaveDetail',
    
    controller: 'leaveDetailViewController',
    viewModel: {type: 'leaveDetailViewModel'},
    	
    layout: 'fit',
    items: [{xtype:'leaveDetailPanel'}]
});