package com.example.fashions.model.bean;

public class LoginBean {

    /**
     * errno : 0
     * errmsg :
     * data : {"code":200,"data":{"id":41,"username":"刘歆遥","gender":0,"user_level_id":0,"avatar":""}}
     */

    private int errno;
    private String errmsg;
    private DataBeanX data;

    public int getErrno() {
        return errno;
    }

    public void setErrno(int errno) {
        this.errno = errno;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public DataBeanX getData() {
        return data;
    }

    public void setData(DataBeanX data) {
        this.data = data;
    }

    public static class DataBeanX {
        /**
         * code : 200
         * data : {"id":41,"username":"刘歆遥","gender":0,"user_level_id":0,"avatar":""}
         */

        private int code;
        private DataBean data;

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public DataBean getData() {
            return data;
        }

        public void setData(DataBean data) {
            this.data = data;
        }

        public static class DataBean {
            /**
             * id : 41
             * username : 刘歆遥
             * gender : 0
             * user_level_id : 0
             * avatar :
             */

            private int id;
            private String username;
            private int gender;
            private int user_level_id;
            private String avatar;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getUsername() {
                return username;
            }

            public void setUsername(String username) {
                this.username = username;
            }

            public int getGender() {
                return gender;
            }

            public void setGender(int gender) {
                this.gender = gender;
            }

            public int getUser_level_id() {
                return user_level_id;
            }

            public void setUser_level_id(int user_level_id) {
                this.user_level_id = user_level_id;
            }

            public String getAvatar() {
                return avatar;
            }

            public void setAvatar(String avatar) {
                this.avatar = avatar;
            }
        }
    }
}
