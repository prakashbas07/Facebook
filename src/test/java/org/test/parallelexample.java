package org.test;

import org.testng.annotations.Test;

public class parallelexample {

	@Test(groups="smoke", singleThreaded=true)
	private void test1() {
		System.out.println("Test1"+Thread.currentThread().getId());
	}
	@Test(groups="smoke",singleThreaded=true)
	private void test2() {
		System.out.println("Test2"+Thread.currentThread().getId());
	}
	@Test(groups="smoke",singleThreaded=true)
	private void test3() {
		System.out.println("Test3"+Thread.currentThread().getId());
	}
	@Test(groups="smoke",singleThreaded=true)
	private void test4() {
		System.out.println("Test4"+Thread.currentThread().getId());
	}
	@Test(groups="smoke")
	private void test5() {
		System.out.println(Thread.currentThread().getId());
	}
	@Test
	private void test6() {
		System.out.println(Thread.currentThread().getId());
	}
	
	@Test
	private void test7() {
		System.out.println(Thread.currentThread().getId());
	}
	@Test
	private void test8() {
		System.out.println(Thread.currentThread().getId());
	}
	@Test
	private void test9() {
		System.out.println(Thread.currentThread().getId());
	}
}
