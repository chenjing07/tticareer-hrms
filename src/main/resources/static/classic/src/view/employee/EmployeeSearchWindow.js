Ext.define('Admin.view.employee.EmployeeSearchWindow', {
    extend: 'Ext.window.Window',
    alias: 'widget.employeeSearchWindow',
	
	y:10,
    height: 200,
   // minHeight: 100,
    //minWidth: 300,
    width: 500,
	
    
    scrollable: true,
    title: '搜索员工',
    closable: true,
    modal:true, //打开窗口后 不能操作其他模块
    
    layout: 'fit',
    
    items: [{
        xtype: 'form',
        layout: 'form',
        padding: '10px',
        ariaLabel: 'Search Employee Information',
        items: [{
            xtype: 'textfield',
            fieldLabel: 'id',
            name:'id',
            hidden: true,
            readOnly: true
        },{
            xtype: 'textfield',
            fieldLabel: '员工工号',
            name:'userName'
        }, {
            xtype: 'textfield',
            fieldLabel: '真实姓名',
            name:'realName'
        }
	]
    }],
    buttons:  ['-\x3e',{
        xtype: 'button',
        text: 'Submit',
        handler: 'searchSubmitButton'//预留提交事件，在ViewController中实现。
    },{
        xtype: 'button',
        text: 'Close',
        handler: function(button) {
            button.up('window').close();
        }
    },'-\x3e']
});

