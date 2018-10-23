Ext.define('Admin.view.salarydetail.SalaryDetailSearchWindow', {
    extend: 'Ext.window.Window',
    alias: 'widget.salaryDetailSearchWindow',

    height: 250,
    minHeight: 100,
    minWidth: 300,
    width: 500,
    scrollable: true,
    title: 'SalaryDetail Search Window',
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
        ariaLabel: 'Search SalaryDetail Information',
        items: [{
            xtype: 'textfield',
            fieldLabel: '员工编号',
            name:'userName'
        },{
            xtype: 'monthfield',
            fieldLabel: '年月信息',
            name:'nowYearMonth',
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
