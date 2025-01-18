import escodegen from 'escodegen'
process.stdin.on('data', (data) => {
    const code = escodegen.generate(JSON.parse(data.toString()))
    console.log(code)
});

