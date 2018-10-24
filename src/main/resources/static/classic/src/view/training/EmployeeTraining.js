Ext.define('Admin.view.training.EmployeeTraining', {
    extend: 'Ext.container.Container',
    xtype: 'employeeTraining',
    
    controller: 'employeeTrainingViewController',
    viewModel: {type: 'employeeTrainingViewModel'},
    	
    layout: 'fit',
    items: [{xtype:'employeeTrainingPanel'}]
});