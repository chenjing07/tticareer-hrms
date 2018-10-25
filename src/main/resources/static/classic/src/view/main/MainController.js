Ext.define('Admin.view.main.MainController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.main',

    listen : {
        controller : {
            '#' : {
                unmatchedroute : 'onRouteChange'
            }
        }
    },

    routes: {
        ':node': 'onRouteChange'
    },

    lastView: null,
    
    clockIn:function(btn){
    	var store = Ext.data.StoreManager.lookup('clockDetailGridStore');
    	Ext.Ajax.request({ 
			url : '/attendance/cd', 
			method : 'post', 
			success: function(response, options) {
                var json = Ext.util.JSON.decode(response.responseText);
	            if(json.data==1 || json.data==2){
	            	Ext.Msg.alert('操作成功', '打卡成功', function() {
	                    store.load();
	                });
		        }else{
		        	 Ext.Msg.alert('操作失败', '打卡失败');
		        }
            }
		});
    },
    
    xiaojia:function(btn){
    	var store1 = Ext.data.StoreManager.lookup('leaveDetailCheckGridStore');
    	var store2 = Ext.data.StoreManager.lookup('leaveDetailGridStore');
    	Ext.Ajax.request({ 
			url : '/attendance/ldxiaojia', 
			method : 'post', 
			success: function(response, options) {
                var json = Ext.util.JSON.decode(response.responseText);
	            if(json.data==1){
	            	Ext.Msg.alert('操作成功', '销假申请已提交', function() {
	                    store1.load();
	                    store2.load();
	                });
		        }else{
		        	 Ext.Msg.alert('操作失败', '销假申请失败');
		        }
            }
		});
    },
    
    setCurrentView: function(hashTag) {
        hashTag = (hashTag || '').toLowerCase();

        var me = this,
            refs = me.getReferences(),
            mainCard = refs.mainCardPanel,
            mainLayout = mainCard.getLayout(),
            navigationList = refs.navigationTreeList,
            store = navigationList.getStore(),
            node = store.findNode('routeId', hashTag) ||
                   store.findNode('viewType', hashTag),
            view = (node && node.get('viewType')) || 'page404',
            lastView = me.lastView,
            existingItem = mainCard.child('component[routeId=' + hashTag + ']'),
            newView;

        // Kill any previously routed window
        if (lastView && lastView.isWindow) {
            lastView.destroy();
        }

        lastView = mainLayout.getActiveItem();

        if (!existingItem) {
            newView = Ext.create({
                xtype: view,
                routeId: hashTag,  // for existingItem search later
                hideMode: 'offsets'
            });
        }

        if (!newView || !newView.isWindow) {
            // !newView means we have an existing view, but if the newView isWindow
            // we don't add it to the card layout.
            if (existingItem) {
                // We don't have a newView, so activate the existing view.
                if (existingItem !== lastView) {
                    mainLayout.setActiveItem(existingItem);
                }
                newView = existingItem;
            }
            else {
                // newView is set (did not exist already), so add it and make it the
                // activeItem.
                Ext.suspendLayouts();
                mainLayout.setActiveItem(mainCard.add(newView));
                Ext.resumeLayouts(true);
            }
        }

        navigationList.setSelection(node);

        if (newView.isFocusable(true)) {
            newView.focus();
        }

        me.lastView = newView;
    },

    onNavigationTreeSelectionChange: function (tree, node) {
        var to = node && (node.get('routeId') || node.get('viewType'));

        if (to) {
            this.redirectTo(to);
        }
    },

    onToggleNavigationSize: function () {
        var me = this,
            refs = me.getReferences(),
            navigationList = refs.navigationTreeList,
            wrapContainer = refs.mainContainerWrap,
            collapsing = !navigationList.getMicro(),
            new_width = collapsing ? 64 : 250;

        if (Ext.isIE9m || !Ext.os.is.Desktop) {
            Ext.suspendLayouts();

            refs.senchaLogo.setWidth(new_width);

            navigationList.setWidth(new_width);
            navigationList.setMicro(collapsing);

            Ext.resumeLayouts(); // do not flush the layout here...

            // No animation for IE9 or lower...
            wrapContainer.layout.animatePolicy = wrapContainer.layout.animate = null;
            wrapContainer.updateLayout();  // ... since this will flush them
        }
        else {
            if (!collapsing) {
                // If we are leaving micro mode (expanding), we do that first so that the
                // text of the items in the navlist will be revealed by the animation.
                navigationList.setMicro(false);
            }
            navigationList.canMeasure = false;

            // Start this layout first since it does not require a layout
            refs.senchaLogo.animate({dynamic: true, to: {width: new_width}});

            // Directly adjust the width config and then run the main wrap container layout
            // as the root layout (it and its chidren). This will cause the adjusted size to
            // be flushed to the element and animate to that new size.
            navigationList.width = new_width;
            wrapContainer.updateLayout({isRoot: true});
            navigationList.el.addCls('nav-tree-animating');

            // We need to switch to micro mode on the navlist *after* the animation (this
            // allows the "sweep" to leave the item text in place until it is no longer
            // visible.
            if (collapsing) {
                navigationList.on({
                    afterlayoutanimation: function () {
                        navigationList.setMicro(true);
                        navigationList.el.removeCls('nav-tree-animating');
                        navigationList.canMeasure = true;
                    },
                    single: true
                });
            }
        }
    },
	
    onMainViewRender:function() {
        if (!window.location.hash) {
            this.redirectTo("login");
        }
    },
    onRouteChange:function(id){
        this.setCurrentView(id);
        //登录校验:没有登录无法访问其他模块.
        /*
        var me = this;
	    if(loginUser!="null" || id=="login"){
			me.setCurrentView(id);
		}else{
			Ext.Msg.alert('警告', '非法登录系统!',function(){
				me.setCurrentView('login');
			});
		}*/
    },
 	/*修改个人信息按钮，保存成功待审核*/
    modifyInformationSubmitButton:function(btn){
		var me = this;
		var win    	= btn.up('window');
		var form 	= win.down('form');
		var values  =form.getValues();
		console.log(values);
        	Ext.Ajax.request({
	            url: 'authentication/modifyinformation',
	            //contentType:'application/json',
	            method: 'post',
	            params: {
	                realName: values.realName,
	                idCardNumber: values.idCardNumber,
	                idCardPicture: values.idCardPicture
	            },
	            success: function(response, options) {
	            	var json = Ext.util.JSON.decode(response.responseText);
		            if(json.success){
		            	Ext.Msg.alert('修改个人信息成功', json.msg);
		            	btn.up('window').add(Ext.widget('login')).show();
			        }else{
			        	Ext.Msg.alert('修改个人信息失败', json.msg);
			        }
	            }
	        });
		win.close();
    },
    	/*修改个人密码*/
    modifyPasswordSubmitButton:function(btn){
		var me = this;
        	Ext.Ajax.request({
	            url: 'authentication/modifypassword',
	            //contentType:'application/json',
	            method: 'post',
	            params: {
	                password: btn.up("form").getForm().findField("password").getValue()
	            },
	            success: function(response, options) {
	            	var json = Ext.util.JSON.decode(response.responseText);
		            if(json.success){
		            	Ext.Msg.alert('修改密码成功', json.msg)
			        }else{
			        	Ext.Msg.alert('修改密码失败', json.msg);
			        }
	            }
	        });
		win.close();
   },
	logoutButton: function(){
		var me = this;
        Ext.Ajax.request({
            url: 'authentication/logout',
            method: 'post',
            success: function(response, options) {
            	var json = Ext.util.JSON.decode(response.responseText);
	            if(json.success){
	            	me.redirectTo('login', true);
	            	window.location.reload();
		        }else{
		        	Ext.Msg.alert('登出失败', json.msg);
		        }
            }
        });
    }
});
