package com.servipack.servipack.auth;

public class JwtConfig {

	public static final String LLAVE_SECRETA = "alguna.clave.secreta.12345678";
	
	public static final String RSA_PRIVADA="-----BEGIN RSA PRIVATE KEY-----\n"
			+ "MIIEowIBAAKCAQEAustkT66WzviY/QKo0GrUWuTXKjju36v8vs5ceff+GB07tTMR\n"
			+ "qiOTkVyPUCzySwoPqWxuuaXHMzTM/GPpX9oOFXY+hm8d7OZHkUWjbAqB1Q3wYJXT\n"
			+ "Iequmhpe2faRv9KFju8PbDaMqVetTRAWr9OANIl5/NJMKoBYq7W+4lUT0r9H8Akz\n"
			+ "2ym2QqfHF9tMLqJrUQnjLqhkL1C3hqezaIvgdRYIMM63bZIeJhSzWXVZ3mxv72cg\n"
			+ "bkOLQyknpj3C+J+SzM3ecS7Y2iAzqSyC7RtpU8b2YT+16iWyWvH/ReUWDMVV36iE\n"
			+ "gkXfcoAOJPyNfTSPtwIlb7ceOTx25XQNusEBHQIDAQABAoIBACZYxtkM0Gzg4Bdg\n"
			+ "ymMu6zVVsU47rd5BInvRRW7MmF8+8Rj7yO6SqyK2S7173KnHAPwZBIocHE7I0iQm\n"
			+ "JqzEyQti4OccPJp7k8mg8DGn3otsdyJ834Eg+oMsUriQQ8+LWlvDe/kNIcdJ9ovR\n"
			+ "d7bUxocCigZ67aP0AUAO6YbxTEaBIC5Ul0L9a+0/yas1+QSh47qOWYlfUmHqVf7E\n"
			+ "XafGMxYsDVjP/JJE5XfFNqcgdRKNGJqUCw+2khMRL3LipUzojm1toA57SgCIaFAt\n"
			+ "PSzpwWBAdm25kFixPolf5EmChVWVWPo9D116kC+LcZ79jx6K4yxHqGyeMQPvCuZ5\n"
			+ "6tgM4sECgYEA61/0F3iYVRdCjKQ6B6vTAiky9kz5GDKQN5dEb9/YVucljP7fQ5OP\n"
			+ "FEEHVNBeTN6OefSA4GUj6E69MO9RHWcJ1M65i6KUBmdAi9ZqyWKwqtIFB+Ecnwam\n"
			+ "PaZ4K1mJZOAC+EolBM5xTo4J58wPd502SoIhJ7qmL4jmNgld4FCk/3UCgYEAyymp\n"
			+ "ALBDsM6fDiyMheEEwgHIT2mt2voJTUMaate+3IvwVpGyKB25EEZ/6JhAy0IeXfRD\n"
			+ "8ysABDGXVljPpRUbmKkGLTTCKY+2ReUlZ5qmJLlcHraiAOM9QPnEWNzkaOfAYEF8\n"
			+ "d1HqJl9tG8J4Sm2FmfjjL1OYEyTJNBUKUSY5LgkCgYEAo7FFxpT+DB9zDvCf0vny\n"
			+ "c8xHPvflPKjdl2vCErPwdu+mM9qFVy/mD8Xx3VBUZM1a9QHQJz7vq/4moUOue+5O\n"
			+ "7gsfCzd0Dsf8IcRq28eg6gvJp+MszoQHVVTSugM5BEiuiBK4kBEqx+EMjoJiN2PE\n"
			+ "gCjj+gda0DA7OlVlTj2HookCgYAhN1d9WFRI5Q9WRuxWuzqG6bmxWirloXnB2xXH\n"
			+ "oCyBbJPH45xIOMvYIF6rTbFSSiYi4Fv3tvESvnTq1ixk5jWT2Ra8b2LLXsbDWLqr\n"
			+ "3LoLSQ8JqnyEPqL2K5/xk3P4vuNSGYLbE1aAHZv+LOZz7MIqMWobg8RaZOpMjKAa\n"
			+ "MnCo2QKBgGcMV+WwaaQtq7HMLIg0dppvj02CAdu49hzacXzsD3r8+zdLCKyYF/M4\n"
			+ "wPDpiL8zSTWtE6F0P9HkQo+n6Id+JvJY4qab/y2xl8/qcrn0BQqWD20YYSw5Amcv\n"
			+ "v/UMOI0opsjz43AG188cczAy3Q7LYxc5og57gvWxEEj0z2P5uFjd\n"
			+ "-----END RSA PRIVATE KEY-----";
	public static final String RSA_PUBLICA="-----BEGIN PUBLIC KEY-----\n"
			+ "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAustkT66WzviY/QKo0GrU\n"
			+ "WuTXKjju36v8vs5ceff+GB07tTMRqiOTkVyPUCzySwoPqWxuuaXHMzTM/GPpX9oO\n"
			+ "FXY+hm8d7OZHkUWjbAqB1Q3wYJXTIequmhpe2faRv9KFju8PbDaMqVetTRAWr9OA\n"
			+ "NIl5/NJMKoBYq7W+4lUT0r9H8Akz2ym2QqfHF9tMLqJrUQnjLqhkL1C3hqezaIvg\n"
			+ "dRYIMM63bZIeJhSzWXVZ3mxv72cgbkOLQyknpj3C+J+SzM3ecS7Y2iAzqSyC7Rtp\n"
			+ "U8b2YT+16iWyWvH/ReUWDMVV36iEgkXfcoAOJPyNfTSPtwIlb7ceOTx25XQNusEB\n"
			+ "HQIDAQAB\n"
			+ "-----END PUBLIC KEY-----";
}
