Ext.define('Admin.view.position.PositionViewController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.positionViewController',
 /*******************************弹窗按钮***********************************/
         /*编辑修改弹窗按钮*/
	openEditWindow:function(grid, rowIndex, colIndex){
		var record = grid.getStore().getAt(rowIndex);
		if (record ) {
			var win = grid.up('container').add(Ext.widget('positionEditWindow'));
			//console.log(record.get('departmentId'));
	         Ext.Ajax.request(
			{
				url:'/department/getDepartmentNameById', 
				method:'get', 
				params:{id:record.get('departmentId')}, 
				success: function(response) {
					var jsonResult = Ext.util.JSON.decode(response.responseText);
					win.show();	
					win.down('form').getForm().loadRecord(record);
					win.down('form').getForm().findField('departmentId').setValue(jsonResult.data);
					
				}
			});
			Ext.Ajax.request(
			{
				url:'/position/getPositionNameById', 
				method:'get', 
				params:{id:record.get('superiorPositionid')}, 
				success: function(response) {
					var jsonResult = Ext.util.JSON.decode(response.responseText);
					win.show();	
					win.down('form').getForm().loadRecord(record);
					win.down('form').getForm().findField('superiorPositionid').setValue(jsonResult.data);
					
				}
			})
	      }
	},
	/*多条件查询弹窗按钮*/	
	openSearchWindow:function(toolbar, rowIndex, colIndex){
		toolbar.up('grid').up('container').add(Ext.widget('positionSearchWindow')).show();		
	},
	/*添加记录弹窗按钮*/	
	openAddWindow:function(grid, rowIndex, colIndex){
		grid.up('container').add(Ext.widget('positionAddWindow')).show();
	},
 /*******************************点击按钮***********************************/
	/*分类单条件查询（快速查询）按钮*/
	quickSearch:function(button){
		var searchField = this.lookupReference('searchFieldName').getValue();
		var searchFieldValue = this.lookupReference('searchFieldValue').getValue();
		var searchFieldValue1 = this.lookupReference('searchFieldValue1').getValue();
		
		var store =	button.up('gridpanel').getStore();
		//var store = Ext.getCmp('userGridPanel').getStore();// Ext.getCmp(）需要在OrderPanel设置id属性
		Ext.apply(store.proxy.extraParams, {positionNumber:"",positionName:""});
		
		if(searchField==='positionNumber'){
			Ext.apply(store.proxy.extraParams, {positionNumber:searchFieldValue});
		}
		if(searchField==='positionName'){
			Ext.apply(store.proxy.extraParams, {positionName:searchFieldValue1});
		}
		store.load({params:{start:0, limit:20, page:1}});
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
        				Ext.Ajax.request({url:'/position/deletes', method:'post', params:{ids:selectIds}, success:function(response, options) {
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
		if(searchField==='positionName'){
			this.lookupReference('searchFieldValue').hide();
			this.lookupReference('searchFieldValue1').show();
		}else{
			this.lookupReference('searchFieldValue').show();
			this.lookupReference('searchFieldValue1').hide();
		}	
	},
/*******************************提交按钮***********************************/
	/*编辑一条记录保存按钮*/
	editSubmitButton:function(button){
		var win=button.up('window');
		var  store=Ext.data.StoreManager.lookup('positionGridStore')
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
		var record = Ext.create('Admin.model.position.PositionModel');
		var values  =form.getValues();//获取form数据 
			console.log(values);
           	record.set(values);
           	record.save();
           	Ext.data.StoreManager.lookup('positionGridStore').load();
             win.close();
	},
	/*查询多条记录条件提交按钮*/
	searchSubmitButton:function(button){
		var store = Ext.data.StoreManager.lookup('positionGridStore');	
		var win=button.up('window');
		var form=win.down('form');
		var values = form.getValues();
		Ext.apply(store.proxy.extraParams, {position_number:'',positionName:''});
		Ext.apply(store.proxy.extraParams, {positionNumber:values.positionNumber,positionName:values.positionName});
		store.load({params:{start:0, limit:20, page:1}});
		win.close();
	}
});

