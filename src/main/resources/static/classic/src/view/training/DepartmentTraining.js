Ext.define('Admin.view.training.DepartmentTraining', {
    extend: 'Ext.container.Container',
    xtype: 'departmentTraining',
    
    controller: 'departmentTrainingViewController',
    viewModel: {type: 'departmentTrainingViewModel'},
    	
    layout: 'fit',
    items: [{xtype:'departmentTrainingPanel'}]
});