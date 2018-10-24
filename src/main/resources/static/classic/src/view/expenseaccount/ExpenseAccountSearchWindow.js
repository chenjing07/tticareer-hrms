Ext.define('Admin.view.expenseaccount.ExpenseAccountWindow', {
    extend: 'Ext.window.Window',
    alias: 'widget.expenseAccountSearchWindow',
    
    autoShow:true,
    height: 300,
    minHeight: 10,
    minWidth: 300,
    width: 500,
    scrollable: true,
    title: 'ExpenseAccount Search Window',
    closable: true,
    modal:true, //打开窗口后 不能操作其他模块
    layout: {  
        type: 'hbox',  
        align: 'center',  
        pack: 'center'  
    },
    items: [{
        xtype: 'form',
        layout: 'form',
        padding: '10px',
        ariaLabel: 'Search ExpenseAccount Information',
        items: [{
            xtype: 'textfield',
            fieldLabel: '员工编号',
            name:'userName'
        },{
            xtype: 'datefield',
            fieldLabel: '开始时间',
            name:'timeStart',
            format: 'Y/m/d H:i:s'
        },{
            xtype: 'datefield',
            fieldLabel: '结束时间',
            name:'timeEnd',
            format: 'Y/m/d H:i:s'
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
