Ext.define('Admin.view.employeePositionInfo.EmployeePositionInfoViewController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.employeePositionInfoViewController',
 /*******************************弹窗按钮***********************************/
         /*编辑修改弹窗按钮*/
	openEditWindow:function(grid, rowIndex, colIndex){
		var record = grid.getStore().getAt(rowIndex);
		if (record ) {
			var win = grid.up('container').add(Ext.widget('employeePositionInfoEditWindow'));
	             win.show();	      
		      win.down('form').getForm().loadRecord(record);
	      }
	},
	/*多条件查询弹窗按钮*/	
	openSearchWindow:function(toolbar, rowIndex, colIndex){
		toolbar.up('grid').up('container').add(Ext.widget('employeePositionInfoSearchWindow')).show();		
	},
	/*添加记录弹窗按钮*/	
	openAddWindow:function(grid, rowIndex, colIndex){
		grid.up('container').add(Ext.widget('employeePositionInfoAddWindow')).show();
	},
 /*******************************点击按钮***********************************/
	/*分类单条件查询（快速查询）按钮*/
	quickSearch:function(button){
		var searchField = this.lookupReference('searchFieldName').getValue();
		var searchFieldValue = this.lookupReference('searchFieldValue').getValue();
		var searchDateFieldValue1 = this.lookupReference('searchDateFieldValue1').getValue();
		var searchDateFieldValue2 = this.lookupReference('searchDateFieldValue2').getValue();
		var store =	button.up('gridpanel').getStore();
		//var store = Ext.getCmp('userGridPanel').getStore();// Ext.getCmp(）需要在OrderPanel设置id属性
		Ext.apply(store.proxy.extraParams, {userName:"",createTimeStart:"",createTimeEnd:""});
		
		if(searchField==='userName'){
			Ext.apply(store.proxy.extraParams, {userName:searchFieldValue});
		}
		if(searchField==='createTime'){
			Ext.apply(store.proxy.extraParams, {createTimeStart:Ext.util.Format.date(searchDateFieldValue1, 'Y/m/d H:i:s'),createTimeEnd:Ext.util.Format.date(searchDateFieldValue2, 'Y/m/d H:i:s')});
		}
		store.load({params:{start:0, limit:10, page:1}});
	},
	/*删除多行按钮*/
	deleteMoreRows:function(button, rowIndex, colIndex){
		var grid = button.up('gridpanel');
  		var selModel = grid.getSelectionModel();
  		if (selModel.hasSelection()) {
    			Ext.Msg.confirm('警告', '确定要删除吗？', function(btn) {
      			if (btn == 'yes') {
        				var rows = selModel.getSelection();
        				var selectIds = [];
        				Ext.each(rows, function(row) {
          					selectIds.push(row.data.id);
        				});
        				Ext.Ajax.request({url:'/employeePositionInfo/deletes', method:'post', params:{ids:selectIds}, success:function(response, options) {
          					var json = Ext.util.JSON.decode(response.responseText);
          					if (json.data) {
            					Ext.Msg.alert('操作成功', json.msg, function() {
              						grid.getStore().reload();
            					});
         				 	} else {
            					Ext.Msg.alert('操作失败', json.msg);
          					}
       				 }});
      			}
    		});
  	} else {
    		Ext.Msg.alert('错误', '没有任何行被选中，无法进行删除操作！');
 	 }
},
	   /*删除一行按钮*/	
	deleteOneRow:function(grid,rowIndex,colIndex){
		 Ext.MessageBox.confirm('提示', '确定要进行删除操作吗？数据将无法还原！', function(button, text) {
	   		 if (button == 'yes') {
				var store = grid.getStore();
				var record = store.getAt(rowIndex);
				store.remove(record);
			}
		},this);
	},
	/*禁用一行按钮*/
	onDisableButton:function(grid, rowIndex, colIndex){
		Ext.Msg.alert("Title","Click Disable Button");
	},
 /*******************************监听按钮***********************************/
	/*combobox选中后监听控制对应输入（文本框和日期框）框显示隐藏*/
	searchComboboxSelectChuang:function(combo,record,index){
		//alert(record.data.name);
		var searchField = this.lookupReference('searchFieldName').getValue();
		if(searchField==='createTime'){
			this.lookupReference('searchFieldValue').hide();
			this.lookupReference('searchDateFieldValue1').show();
			this.lookupReference('searchDateFieldValue2').show();
		}else{
			this.lookupReference('searchFieldValue').show();
			this.lookupReference('searchDateFieldValue1').hide();
			this.lookupReference('searchDateFieldValue2').hide();
		}	
	},
/*******************************提交按钮***********************************/
	/*编辑一条记录保存按钮*/
	editSubmitButton:function(button){
		var win=button.up('window');
		var  store=Ext.data.StoreManager.lookup('employeePositionInfoGridStore')
	      var values=win.down('form').getValues();//获得form数据
	       var record=store.getById(values.id);//获取id获取store中的数据
		record.set(values);
		//store.load();
		win.close();
		//更新事件
	},
	/*添加一条记录提交按钮*/
	addSubmitButton:function(button){
		var win=button.up('window')
		var form=win.down('form');
		var record = Ext.create('Admin.model.employeePositionInfo.EmployeePositionInfoModel');
		var values  =form.getValues();//获取form数据 
			console.log(values);
           	record.set(values);
           	record.save();
           	Ext.data.StoreManager.lookup('employeePositionInfoGridStore').load();
             win.close();
	},
	/*查询多条记录条件提交按钮*/
	searchSubmitButton:function(button){
		var store = Ext.data.StoreManager.lookup('employeePositionInfoGridStore');	
		var win=button.up('window');
		var form=win.down('form');
		var values = form.getValues();
		Ext.apply(store.proxy.extraParams, {userName:'', createTimeStart:'', createTimeEnd:''});
		Ext.apply(store.proxy.extraParams, {userName:values.userName, createTimeStart:Ext.util.Format.date(values.createTimeStart, 'Y/m/d H:i:s'), createTimeEnd:Ext.util.Format.date(values.createTimeEnd, 'Y/m/d H:i:s')});
		store.load({params:{start:0, limit:10, page:1}});
		win.close();
	}
});
