export NATIVE_IMAGE_OPTIONS="--pgo-instrument"
export NATIVE_IMAGE_OPTIONS="--pgo=default.iprof"
export NATIVE_IMAGE_OPTIONS="-Ob --gc=G1 --emit=build-report --enable-sbom"
export NATIVE_IMAGE_OPTIONS="-Ob --gc=epsilon --emit=build-report --enable-sbom"
export NATIVE_IMAGE_OPTIONS="-Ob --gc=serial --emit=build-report --enable-sbom"
 ./mvnw -DskipTests -Pnative native:compile