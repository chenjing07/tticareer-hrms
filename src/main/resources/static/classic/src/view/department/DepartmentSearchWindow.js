Ext.define('Admin.view.department.DepartmentSearchWindow', {
    extend: 'Ext.window.Window',
    alias: 'widget.departmentSearchWindow',

    y:10,
    height: 200,
   // minHeight: 100,
    //minWidth: 300,
    width: 500,
    scrollable: true,
    title: '搜索部门',
    closable: true,
    modal:true, //打开窗口后 不能操作其他模块
    
    layout: 'fit',
    
    items: [{
        xtype: 'form',
        layout: 'form',
        padding: '10px',
        ariaLabel: 'Search Department Information',
        items: [{
            xtype: 'textfield',
            fieldLabel: 'id',
            name:'id',
            hidden: true,
            readOnly: true
        },{
            xtype: 'textfield',
            fieldLabel: '部门编号',
            name:'departmentNumber'
        }, {
            xtype: 'textfield',
            fieldLabel: '部门名称',
            name:'departmentName'
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
