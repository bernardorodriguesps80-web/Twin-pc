# Twin PC v1

Protótipo Android com aparência inspirada no Windows. O app funciona como cliente para abrir uma sessão remota HTTPS em WebView.

## Importante
Este APK **não cria nem hospeda um Windows**. É necessário contratar ou configurar separadamente um servidor/PC remoto e uma sessão web compatível (por exemplo, noVNC). O app não inclui credenciais, servidor ou serviço de nuvem.

## Gerar APK pelo GitHub
1. Crie um repositório no GitHub e envie todos os arquivos deste projeto.
2. Abra a aba **Actions**.
3. Se solicitado, habilite GitHub Actions.
4. Execute **Build Twin PC APK** com **Run workflow** (ou faça push na branch `main`).
5. Ao terminar, abra a execução e baixe o artefato `Twin-PC-v1-debug`.
6. Extraia o ZIP e instale `app-debug.apk` no Android.

O APK é de depuração; para distribuição pública será necessário configurar assinatura de release.
