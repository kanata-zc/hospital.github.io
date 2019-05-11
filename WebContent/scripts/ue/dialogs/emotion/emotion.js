(function(){

    var editor = null;

    UM.registerWidget('emotion',{

        tpl: "<link type=\"text/css\" rel=\"stylesheet\" href=\"<%=emotion_url%>emotion.css\">" +
            "<div class=\"edui-emotion-tab-Jpanel edui-emotion-wrapper\">" +
            "<ul class=\"edui-emotion-Jtabnav edui-tab-nav\">" +
            "<li class=\"edui-tab-item\"><a data-context=\".edui-emotion-Jtab0\" hideFocus=\"true\" class=\"edui-tab-text\"><%=lang_input_choice%></a></li>" +
            "<li class=\"edui-tab-item\"><a data-context=\".edui-emotion-Jtab1\" class=\"edui-tab-text\"><%=lang_input_Tuzki%></a></li>" +
            "<li class=\"edui-tab-item\"><a data-context=\".edui-emotion-Jtab2\" hideFocus=\"true\" class=\"edui-tab-text\"><%=lang_input_lvdouwa%></a></li>" +
            "<li class=\"edui-tab-item\"><a data-context=\".edui-emotion-Jtab3\" hideFocus=\"true\" class=\"edui-tab-text\"><%=lang_input_BOBO%></a></li>" +
            "<li class=\"edui-tab-item\"><a data-context=\".edui-emotion-Jtab4\" hideFocus=\"true\" class=\"edui-tab-text\"><%=lang_input_babyCat%></a></li>" +
            "<li class=\"edui-tab-item\"><a data-context=\".edui-emotion-Jtab5\" hideFocus=\"true\" class=\"edui-tab-text\"><%=lang_input_bubble%></a></li>" +
            "<li class=\"edui-tab-item\"><a data-context=\".edui-emotion-Jtab6\" hideFocus=\"true\" class=\"edui-tab-text\"><%=lang_input_youa%></a></li>" +
            "<li class=\"edui-emotion-tabs\"></li>" +
            "</ul>" +
            "<div class=\"edui-tab-content edui-emotion-JtabBodys\">" +
            "<div class=\"edui-emotion-Jtab0 edui-tab-pane\"></div>" +
            "<div class=\"edui-emotion-Jtab1 edui-tab-pane\"></div>" +
            "<div class=\"edui-emotion-Jtab2 edui-tab-pane\"></div>" +
            "<div class=\"edui-emotion-Jtab3 edui-tab-pane\"></div>" +
            "<div class=\"edui-emotion-Jtab4 edui-tab-pane\"></div>" +
            "<div class=\"edui-emotion-Jtab5 edui-tab-pane\"></div>" +
            "<div class=\"edui-emotion-Jtab6 edui-tab-pane\"></div>" +
            "</div>" +
            "<div class=\"edui-emotion-JtabIconReview edui-emotion-preview-box\">" +
            "<img src=\"<%=cover_img%>\" class=\'edui-emotion-JfaceReview edui-emotion-preview-img\'/>" +
            "</div>",

        sourceData: {
            emotion: {
                tabNum:7, //鍒囨崲闈㈡澘鏁伴噺
                SmilmgName:{ 'edui-emotion-Jtab0':['j_00', 84], 'edui-emotion-Jtab1':['t_00', 40], 'edui-emotion-Jtab2':['w_00', 52], 'edui-emotion-Jtab3':['B_00', 63], 'edui-emotion-Jtab4':['C_00', 20], 'edui-emotion-Jtab5':['i_f', 50], 'edui-emotion-Jtab6':['y_00', 40] }, //鍥剧墖鍓嶇紑鍚�
                imageFolders:{ 'edui-emotion-Jtab0':'jx2/', 'edui-emotion-Jtab1':'tsj/', 'edui-emotion-Jtab2':'ldw/', 'edui-emotion-Jtab3':'bobo/', 'edui-emotion-Jtab4':'babycat/', 'edui-emotion-Jtab5':'face/', 'edui-emotion-Jtab6':'youa/'}, //鍥剧墖瀵瑰簲鏂囦欢澶硅矾寰�
                imageCss:{'edui-emotion-Jtab0':'jd', 'edui-emotion-Jtab1':'tsj', 'edui-emotion-Jtab2':'ldw', 'edui-emotion-Jtab3':'bb', 'edui-emotion-Jtab4':'cat', 'edui-emotion-Jtab5':'pp', 'edui-emotion-Jtab6':'youa'}, //鍥剧墖css绫诲悕
                imageCssOffset:{'edui-emotion-Jtab0':35, 'edui-emotion-Jtab1':35, 'edui-emotion-Jtab2':35, 'edui-emotion-Jtab3':35, 'edui-emotion-Jtab4':35, 'edui-emotion-Jtab5':25, 'edui-emotion-Jtab6':35}, //鍥剧墖鍋忕Щ
                SmileyInfor:{
                    'edui-emotion-Jtab0':['Kiss', 'Love', 'Yeah', '鍟婏紒', '鑳屾壄', '椤�, '鎶栬兏', '88', '姹�, '鐬岀潯', '椴佹媺', '鎷嶇爾', '鎻夎劯', '鐢熸棩蹇箰', '澶х瑧', '鐎戝竷姹梸', '鎯婅', '鑷編', '鍌荤瑧', '鎶涘獨鐪�, '鍙戞�', '鎵撻叡娌�, '淇崸鎾�, '姘旀劋', '?', '鍚�, '鎬�, '鑳滃埄', 'HI', 'KISS', '涓嶈', '涓嶈', '鎵姳', '澶у績', '椤�, '澶ф儕', '椋炲惢', '楝艰劯', '瀹崇緸', '鍙ｆ按', '鐙傚摥', '鏉�, '鍙戣储浜�', '鍚冭タ鐡�'', '濂楃墷', '瀹崇緸', '搴嗙', '鎴戞潵浜�, '鏁叉墦', '鏅曚簡', '鑳滃埄', '鑷編', '琚墦浜�, '璐悆', '杩庢帴', '閰�, '寰瑧', '浜插惢', '璋冪毊', '鎯婃亹', '鑰嶉叿', '鍙戠伀', '瀹崇緸', '姹楁按', '澶у摥', '', '鍔犳补', '鍥�, '浣燦B', '鏅曞�', '寮�績', '鍋风瑧', '澶у摥', '婊存睏', '鍙规皵', '瓒呰禐', '??', '椋炲惢', '澶╀娇', '鎾掕姳', '鐢熸皵', '琚牳', '鍚撳偦', '闅忔剰鍚�],
                    'edui-emotion-Jtab1':['Kiss', 'Love', 'Yeah', '鍟婏紒', '鑳屾壄', '椤�, '鎶栬兏', '88', '姹�, '鐬岀潯', '椴佹媺', '鎷嶇爾', '鎻夎劯', '鐢熸棩蹇箰', '鎽婃墜', '鐫¤', '鐦潗', '鏃犺亰', '鏄熸槦闂�, '鏃嬭浆', '涔熶笉琛�, '閮侀椃', '姝usic', '鎶撳', '鎾炲鑷虫', '姝ご', '鎴崇溂', '椋樿繃', '浜掔浉鎷嶇爾', '鐮嶆浣�, '鎵旀瀛�, '灏戞灄瀵�, '浠�箞锛�, '杞ご', '鎴戠埍鐗涘ザ', '鎴戣涪', '鎽囨檭', '鏅曞帴', '鍦ㄧ瀛愰噷', '闇囪崱'],
                    'edui-emotion-Jtab2':['澶х瑧', '鐎戝竷姹梸', '鎯婅', '鑷編', '鍌荤瑧', '鎶涘獨鐪�, '鍙戞�', '鎴戦敊浜�, 'money', '姘旀劋', '鎸戦�', '鍚�, '鎬�', '鑳滃埄', '濮斿眻', '鍙椾激', '璇村暐鍛紵', '闂槾', '涓�, '閫椾綘鐜╁効', '椋炲惢', '鐪╂檿', '榄旀硶', '鎴戞潵浜�, '鐫′簡', '鎴戞墦', '闂槾', '鎵�, '鎵撴檿浜�, '鍒风墮', '鐖嗘弽', '鐐稿脊', '鍊掔珛', '鍒儭瀛�, '閭伓鐨勭瑧', '涓嶈涓嶈', '鐖辨亱涓�, '鏀惧ぇ浠旂粏鐪�, '鍋风', '瓒呴珮鍏�, '鏅�, '鏉惧彛姘�, '鎴戣窇', '浜彈', '淇吇', '鍝�, '姹�, '鍟妦', '鐑儓娆㈣繋', '鎵撻叡娌�, '淇崸鎾�, '?'],
                    'edui-emotion-Jtab3':['HI', 'KISS', '涓嶈', '涓嶈', '鎵姳', '澶у績', '椤�, '澶ф儕', '椋炲惢', '楝艰劯', '瀹崇緸', '鍙ｆ按', '鐙傚摥', '鏉�, '娉溂', '娴佹唱', '鐢熸皵', '鍚愯垖', '鍠滄', '鏃嬭浆', '鍐嶈', '鎶撶媯', '姹�, '閯欒', '鎷�, '鍚愯', '鍢�, '鎵撲汉', '韫﹁烦', '鍙樿劯', '鎵倝', '鍚僒o', '鍚冭姳', '鍚规场娉＄硸', '澶у彉韬�, '椋炲ぉ鑸�, '鍥炵湼', '鍙�', '鐚涙娊', '娉℃场', '鑻规灉', '浜�, '', '楠氳垶', '鐑ч', '鐫�, '濂楀▋濞�, '鎹呮崊', '鑸炲�', '瑗跨孩鏌�, '鐖辨厱', '鎽�, '鎽囨憜', '鏉傝�', '鎷涜储', '琚', '琚悆闂�, '澶ф儕', '鐞嗘兂', '娆ф墦', '鍛曞悙', '纰�, '鍚愮棸'],
                    'edui-emotion-Jtab4':['鍙戣储浜�', '鍚冭タ鐡�', '濂楃墷', '瀹崇緸', '搴嗙', '鎴戞潵浜�, '鏁叉墦', '鏅曚簡', '鑳滃埄', '鑷編', '琚墦浜�, '璐悆', '杩庢帴', '閰�, '椤�, '骞歌繍', '鐖卞績', '韬�, '閫佽姳', '閫夋嫨'],
                    'edui-emotion-Jtab5':['寰瑧', '浜插惢', '璋冪毊', '鎯婅', '鑰嶉叿', '鍙戠伀', '瀹崇緸', '姹楁按', '澶у摥', '寰楁剰', '閯欒', '鍥�, '澶稿', '鏅曞�', '鐤戦棶', '濯掑﹩', '鐙傚悙', '闈掕洐', '鍙戞剚', '浜插惢', '', '鐖卞績', '蹇冪', '鐜懓', '绀肩墿', '鍝�, '濂哥瑧', '鍙埍', '寰楁剰', '鍛茬墮', '鏆存睏', '妤氭鍙�', '鍥�, '鍝�, '鐢熸皵', '鎯婅', '鍙ｆ按', '褰╄櫣', '澶滅┖', '澶槼', '閽遍挶', '鐏场', '鍜栧暋', '铔嬬硶', '闊充箰', '鐖�, '鑳滃埄', '璧�, '閯欒', 'OK'],
                    'edui-emotion-Jtab6':['鐢峰厹', '濂冲厹', '寮�績', '涔栦箹', '鍋风瑧', '澶х瑧', '鎶芥常', '澶у摥', '鏃犲', '婊存睏', '鍙规皵', '鐙傛檿', '濮斿眻', '瓒呰禐', '??', '鐤戦棶', '椋炲惢', '澶╀娇', '鎾掕姳', '鐢熸皵', '琚牳', '鍙ｆ按', '娉', '鍚撳偦', '鍚愯垖澶�, '鐐瑰ご', '闅忔剰鍚�, '鏃嬭浆', '鍥板洶', '閯欒', '鐙傞《', '绡悆', '鍐嶈', '娆㈣繋鍏変复', '鎭枩鍙戣储', '绋嶇瓑', '鎴戝湪绾�, '鎭曚笉璁环', '搴撴埧鏈夎揣', '璐у湪璺笂']
                }
            }
        },
        initContent:function( _editor, $widget ){

            var me = this,
                emotion = me.sourceData.emotion,
                lang = _editor.getLang( 'emotion' )['static'],
                emotionUrl = UMEDITOR_CONFIG.UMEDITOR_HOME_URL + 'dialogs/emotion/',
                options = $.extend( {}, lang, {
                    emotion_url: emotionUrl
                }),
                $root = me.root();

            if( me.inited ) {
                me.preventDefault();
                this.switchToFirst();
                return;
            }

            me.inited = true;

            editor = _editor;
            this.widget = $widget;

            emotion.SmileyPath = _editor.options.emotionLocalization === true ? emotionUrl + 'images/' : "http://img.baidu.com/hi/";
            emotion.SmileyBox = me.createTabList( emotion.tabNum );
            emotion.tabExist = me.createArr( emotion.tabNum );

            options['cover_img'] = emotion.SmileyPath + (editor.options.emotionLocalization ? '0.gif' : 'default/0.gif');

            $root.html( $.parseTmpl( me.tpl, options ) );

            me.tabs = $.eduitab({selector:".edui-emotion-tab-Jpanel"});

            //缂撳瓨棰勮瀵硅薄
            me.previewBox = $root.find(".edui-emotion-JtabIconReview");
            me.previewImg = $root.find(".edui-emotion-JfaceReview");

            me.initImgName();

        },
        initEvent:function(){

            var me = this;

            //闃叉鐐瑰嚮杩囧悗鍏抽棴popup
            me.root().on('click', function(e){
                return false;
            });

            //绉诲姩棰勮
            me.root().delegate( 'td', 'mouseover mouseout', function( evt ){

                var $td = $( this),
                    url = $td.attr('data-surl') || null;

                if( url ) {
                    me[evt.type]( this, url , $td.attr('data-posflag') );
                }

                return false;

            } );

            //鐐瑰嚮閫変腑
            me.root().delegate( 'td', 'click', function( evt ){

                var $td = $( this),
                    realUrl = $td.attr('data-realurl') || null;

                if( realUrl ) {
                    me.insertSmiley( realUrl.replace( /'/g, "\\'" ), evt );
                }

                return false;

            } );

            //鏇存柊妯℃澘
            me.tabs.edui().on("beforeshow", function( evt ){

                var contentId = $(evt.target).attr('data-context').replace( /^.*\.(?=[^\s]*$)/, '' );

                evt.stopPropagation();

                me.updateTab( contentId );

            });

            this.switchToFirst();

        },
        initImgName: function() {

            var emotion = this.sourceData.emotion;

            for ( var pro in emotion.SmilmgName ) {
                var tempName = emotion.SmilmgName[pro],
                    tempBox = emotion.SmileyBox[pro],
                    tempStr = "";

                if ( tempBox.length ) return;

                for ( var i = 1; i <= tempName[1]; i++ ) {
                    tempStr = tempName[0];
                    if ( i < 10 ) tempStr = tempStr + '0';
                    tempStr = tempStr + i + '.gif';
                    tempBox.push( tempStr );
                }
            }

        },
        /**
         * 鍒囨崲鍒扮涓�釜tab
         */
        switchToFirst: function(){
            this.root().find(".edui-emotion-Jtabnav .edui-tab-text:first").trigger('click');
        },
        updateTab: function( contentBoxId ) {

            var me = this,
                emotion = me.sourceData.emotion;

            me.autoHeight( contentBoxId );

            if ( !emotion.tabExist[ contentBoxId ] ) {

                emotion.tabExist[ contentBoxId ] = true;
                me.createTab( contentBoxId );

            }

        },
        autoHeight: function( ) {
            this.widget.height(this.root() + 2);
        },
        createTabList: function( tabNum ) {
            var obj = {};
            for ( var i = 0; i < tabNum; i++ ) {
                obj["edui-emotion-Jtab" + i] = [];
            }
            return obj;
        },
        mouseover: function( td, srcPath, posFlag ) {

            posFlag -= 0;

            $(td).css( 'backgroundColor', '#ACCD3C' );

            this.previewImg.css( "backgroundImage", "url(" + srcPath + ")" );
            posFlag && this.previewBox.addClass('edui-emotion-preview-left');
            this.previewBox.show();

        },
        mouseout: function( td ) {
            $(td).css( 'backgroundColor', 'transparent' );
            this.previewBox.removeClass('edui-emotion-preview-left').hide();
        },
        insertSmiley: function( url, evt ) {
            var obj = {
                src: url
            };
            obj._src = obj.src;
            editor.execCommand( 'insertimage', obj );
            if ( !evt.ctrlKey ) {
                //鍏抽棴棰勮
                this.previewBox.removeClass('edui-emotion-preview-left').hide();
                this.widget.edui().hide();
            }
        },
        createTab: function( contentBoxId ) {

            var faceVersion = "?v=1.1", //鐗堟湰鍙�
                me = this,
                $contentBox = this.root().find("."+contentBoxId),
                emotion = me.sourceData.emotion,
                imagePath = emotion.SmileyPath + emotion.imageFolders[ contentBoxId ], //鑾峰彇鏄剧ず琛ㄦ儏鍜岄瑙堣〃鎯呯殑璺緞
                positionLine = 11 / 2, //涓棿鏁�
                iWidth = iHeight = 35, //鍥剧墖闀垮
                iColWidth = 3, //琛ㄦ牸鍓╀綑绌洪棿鐨勬樉绀烘瘮渚�
                tableCss = emotion.imageCss[ contentBoxId ],
                cssOffset = emotion.imageCssOffset[ contentBoxId ],
                textHTML = ['<table border="1" class="edui-emotion-smileytable">'],
                i = 0, imgNum = emotion.SmileyBox[ contentBoxId ].length, imgColNum = 11, faceImage,
                sUrl, realUrl, posflag, offset, infor;

            for ( ; i < imgNum; ) {
                textHTML.push( '<tr>' );
                for ( var j = 0; j < imgColNum; j++, i++ ) {
                    faceImage = emotion.SmileyBox[ contentBoxId ][i];
                    if ( faceImage ) {
                        sUrl = imagePath + faceImage + faceVersion;
                        realUrl = imagePath + faceImage;
                        posflag = j < positionLine ? 0 : 1;
                        offset = cssOffset * i * (-1) - 1;
                        infor = emotion.SmileyInfor[ contentBoxId ][i];

                        textHTML.push( '<td  class="edui-emotion-' + tableCss + '" data-surl="'+ sUrl +'" data-realurl="'+ realUrl +'" data-posflag="'+ posflag +'" align="center">' );
                        textHTML.push( '<span>' );
                        textHTML.push( '<img  style="background-position:left ' + offset + 'px;" title="' + infor + '" src="' + emotion.SmileyPath + (editor.options.emotionLocalization ? '0.gif" width="' : 'default/0.gif" width="') + iWidth + '" height="' + iHeight + '"></img>' );
                        textHTML.push( '</span>' );
                    } else {
                        textHTML.push( '<td bgcolor="#FFFFFF">' );
                    }
                    textHTML.push( '</td>' );
                }
                textHTML.push( '</tr>' );
            }
            textHTML.push( '</table>' );
            textHTML = textHTML.join( "" );
            $contentBox.html( textHTML );
        },
        createArr: function( tabNum ) {
            var arr = [];
            for ( var i = 0; i < tabNum; i++ ) {
                arr[i] = 0;
            }
            return arr;
        },
        width:603,
        height:400
    });

})();

